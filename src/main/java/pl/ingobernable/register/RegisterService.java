package pl.ingobernable.register;

import pl.ingobernable.util.RegisterUtil;

class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    void registerUser(String email, String password, String passwordConfirm){

        if (RegisterUtil.isPasswordValid(password) && RegisterUtil.arePasswordsTheSame(password, passwordConfirm)){

            UserDto userDto = new UserDto(email, password);

            registerRepository.registerUser(userDto);

        }
    }


}
