package esbet.start.playground.presentation.controller;

import esbet.start.playground.application.port.in.user.AuthUseCase;
import esbet.start.playground.application.port.in.user.FindUserUseCase;
import esbet.start.playground.domain.model.User;
import esbet.start.playground.presentation.mapper.user.PresentationUserMapper;
import esbet.start.playground.presentation.request.user.RegisterUserRequest;
import esbet.start.playground.presentation.response.user.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final AuthUseCase authUseCase;
    private final FindUserUseCase findUserUseCase;

    private final PresentationUserMapper userMapper;

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserRequest request) {
        log.info("Registering user {} {}", request.getFirstName(), request.getLastName());

        authUseCase.register(request);
    }

   // @GetMapping("/login")

    @GetMapping("getById/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable String id) {
        log.info("Get user by id {}", id);

        User user = findUserUseCase.findUserById(id);

        return ResponseEntity.ok(userMapper.modelToResponse(user));
    }
}
