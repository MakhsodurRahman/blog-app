package com.blogapp.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//jwt part : 4
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtTokenHelper jwtTokenHelper;

    public JwtAuthenticationFilter(UserDetailsService userDetailsService, JwtTokenHelper jwtTokenHelper) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenHelper = jwtTokenHelper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        1.get the token

        String requestToken = request.getHeader("Authorization");
        System.out.println("token :: "+requestToken);

        String userName = null;
        String token = null;
        if(requestToken != null && requestToken.startsWith("Bearer")){
            token = requestToken.substring(7);
            System.out.println("sub token is : "+token);

            try {
                userName = this.jwtTokenHelper.getUsernameFromToken(token);
            }catch (IllegalArgumentException e){
                System.out.println("unable to get jwt token");
            }catch (ExpiredJwtException e){
                System.out.println("jwt token  has expired");
            }catch (MalformedJwtException e){
                System.out.println("invalid jwt");
            }
        }
        else {
            System.out.println("jwt token dose not start with Bearer ");
        }
        //once get the token , now validate
        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){

            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            if(jwtTokenHelper.validateToken(token,userDetails)){
                //authentication required if everything done
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }
            else {
                System.out.println("invalid jwt token");
            }
        }else{
            System.out.println("user name is null or context is not null");
        }

        filterChain.doFilter(request,response);
    }
}
