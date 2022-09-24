package com.blogapp.service.implementation;

import com.blogapp.dto.post.PostRequestDto;
import com.blogapp.dto.post.PostResponseDto;
import com.blogapp.entity.Category;
import com.blogapp.entity.Post;
import com.blogapp.entity.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.payloads.PostResponse;
import com.blogapp.repository.CategoryRepository;
import com.blogapp.repository.PostRepository;
import com.blogapp.repository.UserRepository;
import com.blogapp.service.definition.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PostResponseDto createPost(PostRequestDto postRequestDto, Long userId, Long categoryId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user "," id ",userId));

        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("user "," id ",categoryId));

        Post post = modelMapper.map(postRequestDto,Post.class);
        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post savePost = postRepository.save(post);
        return modelMapper.map(savePost,PostResponseDto.class);
    }

    @Override
    public PostResponseDto updatePost(PostRequestDto postRequestDto, Long id) {

        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post "," post id ",id));

        post.setPostTitle(postRequestDto.getPostTitle());
        post.setContent(postRequestDto.getContent());
        post.setImageName(postRequestDto.getImageName());
        Post savePost = postRepository.save(post);

        return modelMapper.map(savePost,PostResponseDto.class);
    }

    @Override
    public void deletePost(Long id) {

        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post "," id ", id));
        postRepository.delete(post);

    }

    @Override
    public PostRequestDto getPostById(Long id) {

        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post "," id ", id));

        return modelMapper.map(post,PostRequestDto.class);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {

        Sort sort = null;
        if(sortDir.equalsIgnoreCase("asc")){
            sort = Sort.by(sortBy).ascending();
        }else {
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize, sort);
        Page<Post> pagePost = postRepository.findAll(pageable);

        List<Post> posts = pagePost.getContent();

        List<PostResponseDto> responseDtos = posts.stream().map((post)-> modelMapper.map(post,PostResponseDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(responseDtos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }

    @Override
    public List<PostResponseDto> getPostByCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category "," id ",categoryId));

        List<Post> posts = postRepository.findByCategory(category);
        List<PostResponseDto> postDto = posts.stream().map((post) -> modelMapper.map(post, PostResponseDto.class)).collect(Collectors.toList());
        return postDto;
    }

    @Override
    public List<PostResponseDto> getPostByUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user "," id ",userId));

        List<Post> posts = postRepository.findByUser(user);
        List<PostResponseDto> postDto = posts.stream().map((post) -> modelMapper.map(post,PostResponseDto.class)).collect(Collectors.toList());
        return postDto;
    }

    @Override
    public List<PostResponseDto> searchPost(String keyword) {

        List<Post> searchPost = postRepository.findByPostTitleContaining(keyword);
        List<PostResponseDto> responseDtos = searchPost.stream().map((search)->modelMapper.map(search,PostResponseDto.class)).collect(Collectors.toList());
        return responseDtos;
    }
}
