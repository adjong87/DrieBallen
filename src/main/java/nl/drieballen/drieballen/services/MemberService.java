package nl.drieballen.drieballen.services;

import nl.drieballen.drieballen.dtos.MemberDto;
import nl.drieballen.drieballen.dtos.MemberInputDto;
import nl.drieballen.drieballen.exceptions.UsernameNotFoundException;
import nl.drieballen.drieballen.models.Member;
import nl.drieballen.drieballen.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
        Optional<Member> member = memberRepository.findById(username);
        if (member.isPresent()){
            dto = fromMember(member.get());
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
        member.setPassword(memberInputDto.getPassword());
        member.setDoB(memberInputDto.getDoB());
        member.setFirstName(memberInputDto.getFirstName());
        member.setLastName(memberInputDto.getLastName());
        member.setEmail(memberInputDto.getEmail());
        member.setGender(memberInputDto.getGender());
        member.setAge(memberInputDto.getAge());
        member.setAimScore(memberInputDto.getAimScore());
        return member;
    }

    public static MemberDto fromMember(Member member) {
        var dto = new MemberDto();
        dto.setUsername(member.getUsername());
        dto.setDoB(member.getDoB());
        dto.setFirstName(member.getFirstName());
        dto.setLastName(member.getLastName());
        dto.setAimScore(member.getAimScore());
        return dto;
    }

    public void deleteMember(String username) {
        memberRepository.deleteById(username);
    }
}
