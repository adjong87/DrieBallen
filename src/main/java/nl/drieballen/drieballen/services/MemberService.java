package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.dtos.MemberDto;
import nl.drieballen.drieballen.dtos.MemberInputDto;
import nl.drieballen.drieballen.exceptions.UsernameNotFoundException;
import nl.drieballen.drieballen.models.Member;
import nl.drieballen.drieballen.models.User;
import nl.drieballen.drieballen.repositories.MemberRepository;
import nl.drieballen.drieballen.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    private final UserRepository userRepository;

    public MemberService(MemberRepository memberRepository, UserRepository userRepository) {
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
    }

    public List<MemberDto> getAllMembers(){
        List<MemberDto> memberDtoList = new ArrayList<>();
        List<Member>memberList = memberRepository.findAll();
        for(Member member : memberList){
            memberDtoList.add(fromMember(member));
        }
        return memberDtoList;
    }

    public MemberDto getMember(String username) {
        MemberDto dto = new MemberDto();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
//            dto = fromMember();
        }else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public MemberDto addMember(MemberInputDto memberInputDto) {
        Member member = toMember(memberInputDto);
        memberRepository.save(member);
        return fromMember(member);
    }

    private static Member toMember(MemberInputDto memberInputDto) {
        var member = new Member();
        member.setUsername(memberInputDto.getUsername());
        member.setFirstName(memberInputDto.getFirstName());
        member.setLastName(memberInputDto.getLastName());
        member.setEmail(memberInputDto.getEmail());
        member.setAge(memberInputDto.getAge());
        member.setGender(memberInputDto.getGender());
        member.setAimScore(memberInputDto.getAimScore());
        return member;
    }

    public static MemberDto fromMember(Member member) {
        var dto = new MemberDto();
        dto.setUsername(member.getUsername());
        dto.setFirstName(member.getFirstName());
        dto.setLastName(member.getLastName());
        dto.setAge(member.getAge());
        dto.setGender(member.getGender());
        dto.setAimScore(member.getAimScore());
        return dto;
    }

    public void deleteMember(String username) {
        memberRepository.deleteByUsername(username);
    }
}