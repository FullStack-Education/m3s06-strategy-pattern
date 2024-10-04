package com.example.m3s06strategypattern.service;

import com.example.m3s06strategypattern.model.Estoque;
import com.example.m3s06strategypattern.model.Remedio;
import com.example.m3s06strategypattern.repository.EstoqueRepository;
import com.example.m3s06strategypattern.repository.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemedioServiceEx1 {

    @Autowired
    private RemedioRepository remedioRepository;
    @Autowired
    private EstoqueRepository estoqueRepository;

    /**
     * Trocar o nome do método para salvarRemedio
     */
    public void saveRemedio(String nome, Integer dosagemEmMg) {
        /**
         * Esse código está duplicado. Extrair os demais usos para utilizar esse método
         */
        //Salvar o remédio quando não encontrarmos
        Remedio remedio = new Remedio();
        remedio.setNome(nome);
        remedio.dosagemMg(dosagemEmMg);
        /**
         * Podemos extrair cada uma dessas validações para métodos específicos
         * Por exemplo: validaExistenciaNome(); validaExistenciaDosagem(); validaDosagemDeveSerPositiva();
         */
        if (nome == null || nome.isEmpty() || nome.trim().isEmpty()) {
            /**
             * Ter uma exceção de Parametro inválido
             * Parâmetro inválido poderia receber o campo
             * throw new ParametroInvalidoException("quantidade", "Quantidade adicionada no estoque não pode ser negativa");
             */

            throw new RuntimeException("Nome do remédio não pode ser vazio");
            /**
             * Esse else if é redundante. Se tirarmos não afetará o fluxo do código.
             */
        } else if (dosagemEmMg == null || dosagemEmMg < 0) {
            if (dosagemEmMg == null) {
                /**
                 * throw new ParametroInvalidoException("dosagemEmMg", "Remédio precisa possuir dosagem");
                 */
                throw new RuntimeException("Remédio precisa possuir dosagem");
            } else if (dosagemEmMg < 0) {
                /**
                 * throw new ParametroInvalidoException("dosagemEmMg", "Dosagem não pode ser negativa");
                 */
                throw new RuntimeException("Dosagem não pode ser negativa");
            }
        }
        remedioRepository.save(remedio);
    }

    /**
     * Ao invés de addEstoque, podemos chamar de adicionarNoEstoque
     * trocar idR por idRemedio
     * trocar nomeR por nomeRemedio
     * padronizar remedioDosagemMg por dosagemMgRemedio
     */
    public void addEstoque(Integer idR, Integer quantidade, String nomeR, Integer remedioDosagemMg) {
        //Se existe remedio eu adiciono o estoque
        if (remedioRepository.existe(idR)) {
            /**
             * Trocar nome da variável por remedio
             */
            Remedio r = remedioRepository.getRemedioPorId(idR);
            /**
             * Trocar nome da variável por estoqueAtual
             */
            Estoque eAtual = estoqueRepository.getEstoqueAtual(idR);
            if(eAtual == null) {
                /**
                 * Criar um método que cria um estoque quando não existe
                 * E então setar a quantidade sem necessitar do if
                 */
                //Cria um novo estoque quando não encontrou
                Estoque estoque = new Estoque();
                estoque.setIdRemedio(r.getId());
                estoque.setQuantidade(quantidade);
                if (quantidade < 0) {
                    /**
                     * throw new ParametroInvalidoException("quantidade", "Quantidade adicionada no estoque não pode ser negativa");
                     */
                    throw new RuntimeException("Quantidade adicionada no estoque não pode ser negativa");
                }
                estoqueRepository.save(estoque);
            }
            /**
             * Esse else não terá necessidade de existir se o método criaEstoqueSeNaoExiste for implementado
             */
            else {
                if (quantidade < 0) {
                    throw new RuntimeException("Quantidade adicionada no estoque não pode ser negativa");
                }
                eAtual.setQuantidade(eAtual.getQuantidade() + quantidade);
                estoqueRepository.save(eAtual);
            }
            /**
             * Ao invés de ter dois ifs, cada um buscando o remédio de alguma forma, podemos criar um método
             * encontraRemedio e mandar o idRemedio e o nomeRemedio como parâmetro
             */
        } else if (remedioRepository.existePorNome(nomeR)) {
            Remedio r = remedioRepository.getRemedioPorNome(nomeR);
            Estoque eAtual = estoqueRepository.getEstoqueAtual(r.getId());
            /**
             * Esse trecho abaixo está duplicado. Podemos remover
             */
            if(eAtual == null) {
                if (quantidade < 0) {
                    throw new RuntimeException("Quantidade adicionada no estoque não pode ser negativa");
                }
                Estoque estoque = new Estoque();
                estoque.setQuantidade(quantidade);
                estoque.setIdRemedio(r.getId());
                estoqueRepository.save(estoque);
            }
            else {
                if (quantidade < 0) {
                    throw new RuntimeException("Quantidade adicionada no estoque não pode ser negativa");
                }
                eAtual.setQuantidade(eAtual.getQuantidade() + quantidade);
                estoqueRepository.save(eAtual);
            }
        } else {
            /**
             * Ao invés de deixar esse comentário, podemos criar um método que tenha a nomenclatura adequada
             * para a regra de negócio. Ex: salvarRemedio
             */
            //Salvar o remédio quando não encontrarmos
            Remedio r = new Remedio();
            r.setNome(nomeR);
            r.dosagemMg(remedioDosagemMg);
            if (nomeR == null || nomeR.isEmpty() || nomeR.trim().isEmpty()) {
                throw new RuntimeException("Nome do remédio não pode ser vazio");
            } else if (remedioDosagemMg == null || remedioDosagemMg < 0) {
                if (remedioDosagemMg == null) {
                    throw new RuntimeException("Remédio precisa possuir dosagem");
                } else if (remedioDosagemMg < 0) {
                    throw new RuntimeException("Dosagem não pode ser negativa");
                }
            }
            Integer id = remedioRepository.save(r);

            /**
             * Lógica abaixo está também duplicada. Já tinha sido feita anteriormente
             */
            //Adicionar no estoque novo
            Estoque estoque = new Estoque();
            estoque.setIdRemedio(id);
            estoque.setQuantidade(quantidade);
            if (quantidade < 0) {
                throw new RuntimeException("Quantidade adicionada no estoque não pode ser negativa");
            }
            estoqueRepository.save(estoque);
        }
    }
}
