// Pacote onde a classe está localizada
package com.javanauta.cadastro_usuario.controller;

import com.javanauta.cadastro_usuario.business.UsuarioService;
import com.javanauta.cadastro_usuario.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Indica que esta classe é um controlador REST (retorna JSON, não páginas HTML)
@RestController
// Define o caminho base da API: todas as rotas aqui começam com /usuario
@RequestMapping("/usuario")
// Gera automaticamente um construtor com todos os atributos "final" (injeção de dependência via construtor)
@RequiredArgsConstructor
public class UsuarioController {

    // Injeção do service responsável pelas regras de negócio
    private final UsuarioService usuarioService;

    // Método para salvar um novo usuário no banco (POST = criar recurso)
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        // Chama o service para salvar
        usuarioService.salvarUsuario(usuario);
        // Retorna resposta 200 (OK) sem corpo
        return ResponseEntity.ok().build();
    }

    // Método para buscar usuário pelo email (GET = consultar dados)
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        // Chama o service e retorna o usuário com status 200
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    // Método para deletar um usuário usando email (DELETE = remover recurso)
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        // Remove o usuário
        usuarioService.deletarUsuarioPorEmail(email);
        // Retorna 200 sem corpo
        return ResponseEntity.ok().build();
    }

    // Método para atualizar dados do usuário (PUT = atualizar recurso)
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario){
        // Chama o service, passando o ID e os novos dados
        usuarioService.atualizarUsuarioPorId(id, usuario);
        // Resposta de sucesso
        return ResponseEntity.ok().build();
    }
}
