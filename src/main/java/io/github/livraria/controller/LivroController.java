package io.github.livraria.controller;

import io.github.livraria.model.Livro;
import io.github.livraria.repository.LivroRepository;
import io.github.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listar(){
        return livroService.listarTodos();
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro){
        return livroService.salvar(livro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
        return livroService.buscarPorId(id)
                .map(livro -> ResponseEntity.ok(livro))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo){
        return livroService.buscarPorTitulo(titulo);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro){
        livro.setId(id); //Definindo o ID do livro a ser atualizado
        return livroService.salvar(livro);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        livroService.excluir(id);
    }
}
