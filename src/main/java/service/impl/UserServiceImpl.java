package service.impl;

import domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).{8,20}$");

    @Override
    public void register(String email, String password, String nickname) {

        // 이메일 중복 검사
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }

        //비밀번호 양식 체크
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException("비밀번호는 8-20자 사이여야 하며, 최소 하나의 문자, 숫자 및 특수문자를 포함해야 합니다");
        }

        User user = new User(email, password, nickname);

        userRepository.save(user);
    }

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void update(Long id, String nickname) {
        User user = userRepository.findById(id).get();

        user.update(nickname);
    }

    @Override
    public void updatePassword(Long id, String password) {
        User user = userRepository.findById(id).get();

        user.updatePassword(password);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).get();

        user.delete();
    }
}
