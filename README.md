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
