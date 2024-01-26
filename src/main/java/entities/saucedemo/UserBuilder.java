package entities.saucedemo;

import lombok.*;

@Data
@Builder(setterPrefix = "with")
public class UserBuilder {
    private String username;
    private String password;
}

// --Builder without Lombok--
//    public static class Builder {
//        private final UserBuilder userBuilder;
//
//        public Builder withUsername(String username) {
//            userBuilder.username = username;
//            return this;
//        }
//
//        public Builder withPassword(String password) {
//            userBuilder.password = password;
//            return this;
//        }
//
//        public Builder() {
//            this.userBuilder = new UserBuilder();
//        }
//
//        public UserBuilder build() {
//            return userBuilder;
//        }
//    }

