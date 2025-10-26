// Pacote onde esta classe (entidade Usuario) está localizada
package com.javanauta.cadastro_usuario.infrastructure.entitys;

// Importações para mapeamento da entidade JPA (Hibernate)
import jakarta.persistence.*;
// Importações do Lombok para gerar automaticamente getters, setters e construtores
import lombok.*;

// Lombok gera automaticamente os métodos get
@Getter
// Lombok gera automaticamente os métodos set
@Setter
// Gera um construtor com todos os argumentos (todos os campos)
@AllArgsConstructor
// Gera um construtor vazio (sem argumentos)
@NoArgsConstructor
// Gera o padrão Builder (para criar objetos de forma flexível e legível)
@Builder
// Mapeia esta classe para a tabela "usuario" no banco de dados
@Table(name = "usuario")
// Indica que esta classe é uma entidade JPA, representando uma tabela no banco
@Entity
public class Usuario {

    // Define que este campo é a chave primária da tabela
    @Id
    // Gera automaticamente o valor do ID (ex: auto incremento no banco)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Mapeia a coluna "emaill" (observação: está escrito com dois 'l', você quer manter assim?)
    // 'unique = true' garante que não podem existir dois registros com o mesmo email
    @Column(name = "emaill", unique = true)
    private String email;

    // Mapeia a coluna "nome" no banco
    @Column(name = "nome")
    private String nome;
}
