package de.waksh.aposoft;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.waksh.aposoft.domain.Protocol;
import de.waksh.aposoft.repository.ProtocolRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
@Transactional
public class ProtocolTest {

    @Autowired
    private ProtocolRepository repository;

    private Protocol createProtocol() {
        Protocol protocol = new Protocol();

        protocol.setDescription("abc");

        return protocol;
    }

    @Test
    public void testFindAll() {
        Protocol protocol = createProtocol();

        long size = repository.count();
        long length = 0;
        repository.save(protocol);
        Iterable<Protocol> it = repository.findAll();
        for (@SuppressWarnings("unused") Protocol protocol2 : it) {
            length++;
        }
        Assert.assertEquals(size + 1, length);
    }
}
