package io.github.livraria.service;

import io.github.livraria.model.Livro;
import io.github.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id){
        return livroRepository.findById(id);
    }

    public void excluir(Long id){
        livroRepository.deleteById(id);
    }

    public List<Livro> buscarPorTitulo(String titulo){
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }
}
