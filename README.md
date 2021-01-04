# security-sb
- @EnableWebSecurity
- extends WebSecurityConfigurerAdapter {}
- void configure(AuthenticationManagerBuilder auth) {
 auth.inMemoryAuthentication().withUser("user").password("user").roles("USER")
 .and().withUser("admin").password("admin").roles("ADMIN");
}
- @Bean
  public PasswordEncoder passwordEncoder() {
   return NoOpPasswordEncoder.getInstance();
  }
 - void configure(HttpSecurity http) {
  http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
  .antMatchers("/user").hasAnyRole("ADMIN", "USER")
  .antMatchers("/").permitAll()
  .and().formLogin();
 }
 - @GetMapping("/")
 - @GetMapping("/user")
 - @GetMapping("/admin")

### Security using JDBC API
- @Autowired DataSource datasource;
- configure(AuthenticationManagerBuilder auth) {

     //option 1 with username and password set for default schema
     
     auth.jdbcAuthentication()
     
         .dataSource(datasource)
         
         .withDefaultSchema()
         
         .withUser(User.withUserName("user").password("user").roles("USER"))
         
         .withUser(User.withUserName("admin").password("admin").roles("ADMIN");
         
     //option 2 with users created using schema and data.sql
     
     //data.sql
     insert into users (username, password, enabled) values('user', 'user', true);
     
     insert into users (username, password, enabled) values('user', 'user', true);
     
     insert into authorities (username, authority) values('user', 'ROLE_USER');
     insert into authorities (username, authority) values('admin', 'ROLE_ADMIN');
     
     configure(AuthenticationManagerBuilder auth) {
     
     auth.jdbcAuthentication().dataSource(datasource);
     
     }
     
     // option 3 with users created using datasource and using query in configuration
     
     configure(AuthenticationManagerBuilder auth) {
     
        auth.jdbcAuthentication()
        
        .dataSource(datasource)
        
        .usersByUsernameQuery("select username, password, enabled from users where username = ?")
        
        .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
        
     }
  }
