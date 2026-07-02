package com.projetopraticoDS.projetopraticoDS;

import static org.assertj.core.api.Assertions.assertThat;

import com.projetopraticoDS.projetopraticoDS.entities.Pessoa;
import com.projetopraticoDS.projetopraticoDS.entities.Porteiro;
import com.projetopraticoDS.projetopraticoDS.repositories.PessoaRepository;
import com.projetopraticoDS.projetopraticoDS.repositories.PorteiroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PorteiroPersistenceTests {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PorteiroRepository porteiroRepository;

    @Test
    void cadastraListaEExcluiPorteiroComPessoa() {
        var pessoa = new Pessoa(null, "Porteiro Teste", "porteiro.teste@email.com", "123456", "999.999.999-99");
        pessoa.setTipo("Porteiro");
        pessoa.setTelefone("(31) 99999-9999");
        pessoa.setStatus("Ativo");

        var pessoaSalva = pessoaRepository.save(pessoa);

        var porteiro = new Porteiro();
        porteiro.setPessoa(pessoaSalva);
        var porteiroSalvo = porteiroRepository.save(porteiro);

        assertThat(porteiroRepository.findAll())
                .hasSize(1)
                .first()
                .satisfies(item -> {
                    assertThat(item.getIdPorteiro()).isEqualTo(porteiroSalvo.getIdPorteiro());
                    assertThat(item.getPessoa().getNome()).isEqualTo("Porteiro Teste");
                    assertThat(item.getPessoa().getTipo()).isEqualTo("Porteiro");
                    assertThat(item.getPessoa().getTelefone()).isEqualTo("(31) 99999-9999");
                });

        porteiroRepository.deleteById(porteiroSalvo.getIdPorteiro());
        pessoaRepository.deleteById(pessoaSalva.getIdPessoa());

        assertThat(porteiroRepository.findAll()).isEmpty();
        assertThat(pessoaRepository.findById(pessoaSalva.getIdPessoa())).isEmpty();
    }
}
