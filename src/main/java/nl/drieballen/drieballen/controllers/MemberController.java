package nl.drieballen.drieballen.controllers;

import nl.drieballen.drieballen.dtos.MemberDto;
import nl.drieballen.drieballen.dtos.MemberInputDto;
import nl.drieballen.drieballen.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MemberDto>> getAllMembers(){
        List<MemberDto>memberDtoList;
        memberDtoList = memberService.getAllMembers();
        return ResponseEntity.ok().body(memberDtoList);
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<MemberDto> getMember(@RequestParam("username") String username) {
        MemberDto optionalMember = memberService.getMember(username);
        return ResponseEntity.ok().body(optionalMember);
    }

    @PostMapping("/add")
    public MemberDto addMember(@RequestBody MemberInputDto memberInputDto){
        return memberService.addMember(memberInputDto);
    }

    @DeleteMapping(value = "/delete/{username}")
    public String deleteMember(@PathVariable("username") String username) {
        memberService.deleteMember(username);
        return "Gebruiker " + username + " is verwijderd";
    }
}
