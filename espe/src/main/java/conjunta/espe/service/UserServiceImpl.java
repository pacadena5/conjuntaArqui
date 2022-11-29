package conjunta.espe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import conjunta.espe.model.User;
import conjunta.espe.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository clientRepository;

    @Override
    public List<User> getAllUser(){
        return clientRepository.findAll();
    }
}
