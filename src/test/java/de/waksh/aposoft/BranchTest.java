package de.waksh.aposoft;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Branch;
import de.waksh.aposoft.domain.Occupation;
import de.waksh.aposoft.domain.User;
import de.waksh.aposoft.repository.BranchRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class BranchTest {

    @Autowired
    private BranchRepository repository;

    private Branch createBranch() {
        Branch branch = new Branch();

        branch.setDescription("Beschreibung");
        branch.setAddress("Straße");
        branch.setLocation("Hier");
        branch.setManager("Manager");
        branch.setLogo("Logo");

        Occupation occupation = new Occupation();
        // occupation.setQualification("qualifikation");
        Occupation occu = new Occupation();
        // occu.setQualification("quali");
        List<Occupation> occupations = new ArrayList<>();
        occupations.add(occu);
        occupations.add(occupation);
        branch.setOccupations(occupations);

        User user = new User();
        user.setFirstName("first");
        user.setName("name");
        User user2 = new User();
        user2.setFirstName("f");
        user2.setName("n");
        List<User> users = new ArrayList<>();
        branch.setUsers(users);

        return branch;
    }

    @Test
    public void testFindAll() {
        Branch branch = createBranch();

        long size = repository.count();
        long length = 0;
        repository.save(branch);
        Iterable<Branch> it = repository.findAll();
        for (@SuppressWarnings("unused") Branch branch2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }

}
