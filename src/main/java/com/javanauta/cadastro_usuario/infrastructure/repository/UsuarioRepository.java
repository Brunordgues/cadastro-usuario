// Pacote onde o repositório está localizado
package com.javanauta.cadastro_usuario.infrastructure.repository;

import com.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interface que representa o repositório de acesso ao banco de dados
// Ela estende JpaRepository para herdar métodos prontos como save, findAll, delete, etc.
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Busca um usuário pelo email.
    // O Optional evita erro de NullPointerException caso o email não seja encontrado.
    Optional<Usuario> findByEmail(String email);

    // Deleta um usuário pelo email.
    // A anotação @Transactional garante que a operação de exclusão seja executada dentro de uma transação.
    @Transactional
    void deleteByEmail(String email);
}
