package me.xiaotian.ichat.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by guoxiaotian on 2017/5/16.
 */

@SpringBootApplication
@ImportResource({"classpath:spring/dubbo-customer.xml"})
@ComponentScan(basePackages = "me.xiaotian.ichat.family")
public class App {
    public static void main(String[] argv) {
        SpringApplication.run(App.class, argv);
    }

}


//@Configuration
//class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
////    @Resource
////    private FamilyUserService familyUserService;
////    AccountRepository accountRepository;
//
//    @Autowired
//    private AuthProvider authProvider;
//
//
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider);
////        auth.userDetailsService(userDetailsService());
//    }
//
////    @Bean
////    UserDetailsService userDetailsService() {
////        return new UserDetailsService() {
////
////            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////
////                FamilyUserEntity userEntity = familyUserService.findByPhone(username);
////                if (userEntity != null) {
////                    return new User(userEntity.getPhone(), userEntity.getPass(), true, true, true, true,
////                            AuthorityUtils.createAuthorityList("USER"));
////                } else {
////                    throw new UsernameNotFoundException("could not find the user '"
////                            + username + "'");
////                }
////            }
////
////        };
////    }
//}
//
//@EnableWebSecurity
//@Configuration
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().fullyAuthenticated().and().
//                httpBasic().and().
//                csrf().disable();
//    }
//}