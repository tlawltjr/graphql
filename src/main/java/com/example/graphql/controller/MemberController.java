package com.example.graphql.controller;

import com.example.graphql.entity.Car;
import com.example.graphql.entity.Member;
import com.example.graphql.repository.CarRepository;
import com.example.graphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final CarRepository carRepository;

    @QueryMapping
    public Member getMember(@Argument Long id) {
        return memberRepository.findById(id).orElseGet(() -> new Member());
    }
    @QueryMapping
    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    @MutationMapping
    public Member save(@Argument Long id, @Argument String name, @Argument int age){
        Member member = Member.builder()
                .name(name)
                .age(age)
                .build();
        return memberRepository.save(member);
    }

    @SchemaMapping
    public List<Car> car(Member member){
        return carRepository.findByMemberId(member.getId().intValue());
    }


}
