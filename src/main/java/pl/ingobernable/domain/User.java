package pl.ingobernable.domain;

class User {

    private String email;
    private String password;

    @SuppressWarnings("unused")
    User(){}

    User(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    UserSnapshot getSnapshot(){
        return new UserSnapshot(email, password);
    }

    User restore(UserSnapshot snapshot){
        return new User(snapshot.getEmail(), snapshot.getPassword());
    }
}