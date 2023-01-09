package com.Student.entity;

import com.Student.exception.ResourceNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class StudentUserDetailsService implements UserDetails {
  private Student student;

  public StudentUserDetailsService(Student student){
      this.student=student;
  }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> set=new HashSet<>();
        set.add(new SimpleGrantedAuthority(this
                .student.getRole()));
        return set;
    }

    @Override
    public String getPassword() {
      try{
          return this.student.getPassword();
      }catch (Exception e){
          throw new ResourceNotFoundException("eroor");
//          return "Login Credential invalide";
      }

    }

    @Override
    public String getUsername() {
        try{
            return this.student.getEmail();
        }catch (Exception e){
            throw new ResourceNotFoundException("Error With Email Please check once");
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
