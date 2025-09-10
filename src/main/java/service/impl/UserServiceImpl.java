package service.impl;

import domain.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void register(String email, String password, String nickname) {

    }

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public void update(Long id, String nickname) {

    }

    @Override
    public void updatePassword(Long id, String password) {

    }

    @Override
    public void delete(Long id) {

    }
}
