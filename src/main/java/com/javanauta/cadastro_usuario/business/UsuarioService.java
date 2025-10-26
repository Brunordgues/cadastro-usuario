// Pacote onde esta classe está localizada
package com.javanauta.cadastro_usuario.business;

// Importa a entidade Usuario, que representa a tabela no banco de dados
import com.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
// Importa o repositório que faz a comunicação com o banco de dados
import com.javanauta.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

// Anotação opcional importada (não está sendo usada nesse código)
import javax.sound.sampled.UnsupportedAudioFileException;

// Indica que esta classe é um serviço no Spring (regra de negócio)
@Service
public class UsuarioService {

    // Injeção do repositório para acessar o banco de dados
    private final UsuarioRepository repository;

    // Construtor para inicializar o repositório (injeção de dependência)
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Método para salvar ou atualizar um usuário no banco
    public void salvarUsuario(Usuario usuario){
        // saveAndFlush salva e força a gravação imediatamente no banco
        repository.saveAndFlush(usuario);
    }

    // Método para buscar um usuário pelo email
    public Usuario buscarUsuarioPorEmail(String email){
        // findByEmail retorna um Optional. Se não existir, lança exceção.
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    // Método para deletar um usuário usando o email
    public void deletarUsuarioPorEmail(String email){
        // deleteByEmail remove diretamente pelo email
        repository.deleteByEmail(email);
    }

    // Método para atualizar os dados de um usuário com base no ID
    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        // Primeiro, busca o usuário existente no banco pelo ID
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));

        // Cria um novo objeto Usuario com os dados atualizados
        // Somente atualiza os campos que não forem nulos na requisição
        Usuario usuarioAtualizado = Usuario.builder()
                // Se o novo email não for nulo, usa ele, senão mantém o antigo
                .email(usuario.getEmail() != null ? usuario.getEmail() :
                        usuarioEntity.getEmail())
                // Se o novo nome não for nulo, usa ele, senão mantém o antigo
                .nome(usuario.getNome() != null ? usuario.getNome() :
                        usuarioEntity.getNome())
                // Mantém o mesmo ID do usuário original
                .id(usuarioEntity.getId())
                .build();

        // Salva o usuário atualizado no banco
        repository.saveAndFlush(usuarioAtualizado);
    }
}
