package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Branch;
import de.waksh.aposoft.repository.BranchRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfiguration.class)
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
