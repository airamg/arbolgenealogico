package edu.uoc.arbolgenealogico;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import edu.uoc.arbolgenealogico.pojo.Usuario;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class TestUsuario {

    @Test
    public void testUsuarioImagenAsociada() {
        Usuario u = new Usuario();
    	assertTrue(!u.getRuta_imagen().equals(""));
    }
 
}