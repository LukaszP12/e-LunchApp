package pl.strefakursow.eLunchApp.service;

import com.google.common.base.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.eLunchApp.DTO.UserDTO;
import pl.strefakursow.eLunchApp.model.User;
import pl.strefakursow.eLunchApp.repo.UserRepo;
import pl.strefakursow.eLunchApp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    @Override
//    public List<UserDTO> getAll() {
//        return userRepo.findAll().stream()
//                .map(ConverterUtils::convert)
//                .collect(Collectors.toList());
//    }

    @Override
    public void put(UUID uuid, UserDTO userDTO) {

    }

    @Override
    public void delete(UUID uuid) {
        User user = userRepo.findByUUID(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepo.deleteById(user.getId());
    }

    @Override
    public List<UserDTO> getAll() {
        return null;
    }

    @Override
    public Optional<UserDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }

    //    @Override
//    public Optional<UserDTO> getByUuid(UUID uuid) {
//        return userRepo
//                .findByUUID(uuid)
//                .map(ConverterUtils::convert);
//    }

    @Override
    public void validateNewOperation(UUID uuid, UserDTO userDTO) {
        if (!Objects.equal(userDTO.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        userRepo.findByUUID(userDTO.getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
