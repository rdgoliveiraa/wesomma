package com.app.wesomma.application.resource;

import com.app.wesomma.application.form.UserForm;
import com.app.wesomma.application.service.AccountService;
import com.app.wesomma.application.service.BudgetService;
import com.app.wesomma.application.service.FamilyService;
import com.app.wesomma.application.service.UserService;
import com.app.wesomma.application.util.UserUtil;
import com.app.wesomma.domain.account.Account;
import com.app.wesomma.domain.account.AccountRepository;
import com.app.wesomma.domain.account.AccountType;
import com.app.wesomma.domain.account.AccountTypeRepository;
import com.app.wesomma.domain.budget.Budget;
import com.app.wesomma.domain.budget.BudgetRepository;
import com.app.wesomma.domain.group.Family;
import com.app.wesomma.domain.group.GroupRepository;
import com.app.wesomma.domain.institution.Institution;
import com.app.wesomma.domain.institution.InstitutionRepository;
import com.app.wesomma.domain.person.User;
import com.app.wesomma.domain.person.UserDTO;
import com.app.wesomma.domain.person.UserRepository;
import com.app.wesomma.domain.profile.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/user")
@CrossOrigin(origins = "*")
public class UserResource {

    private static Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    BudgetService budgetService;

    @Autowired
    UserService userService;

    @Autowired
    FamilyService familyService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> detailById(@PathVariable(value = "id") Long id) {
        logger.info("Iniciando detailById id: " + id);
        if(id == 0) {
            ResponseEntity.notFound().build();
        }
        Optional<User> optional = userRepository.findById(id);
        return optional.map(value -> ResponseEntity.ok(new UserDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/family")
    public Page<UserDTO> listAllByFamily(@RequestParam Long familyId,
                                         @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pagination) {
        logger.info("Iniciando listAllByPerson personId: " + familyId);
        Optional<Family> family = groupRepository.findById(familyId);
        Page<User> users = userRepository.findAllByFamilyId(familyId, pagination);
        return UserDTO.converter(users);
    }

    @PostMapping
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriBuilder) {
        User user = userForm.converter();


        profileRepository.saveAll(user.getProfiles());
        userService.createUser(user);
        Family family = familyService.createFamily(user);
        budgetService.createBudget(user, family);
        user = accountService.createAccount(user);

        URI uri = uriBuilder.path("/person/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(UserUtil.parse(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userService.deleteUser(user.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

}
