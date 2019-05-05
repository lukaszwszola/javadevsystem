package com.wszola.javadevsystem.system;

import com.wszola.javadevsystem.student.Student;
import com.wszola.javadevsystem.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class JDSUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Student student = studentRepository.findByStudentNoOrEmail(login, login);

        if (student == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("USER"));

        if (login.equals(student.getStudentNo())) {
            return new User(student.getStudentNo(), student.getPassword(), authorities);
        } else {
            return new User(student.getEmail(), student.getPassword(), authorities);
        }
    }
}
