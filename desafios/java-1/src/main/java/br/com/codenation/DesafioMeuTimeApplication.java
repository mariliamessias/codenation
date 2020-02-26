package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.jogadores.Jogador;
import br.com.codenation.times.Time;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> times = new ArrayList<>();
	List<Jogador> jogadores = new ArrayList<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(buscarTimePorId(id).isPresent()) throw new IdentificadorUtilizadoException();
		times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if(buscarJogadorPorId(id).isPresent()) throw new IdentificadorUtilizadoException();
		buscarTimePorId(id).orElseThrow(TimeNaoEncontradoException::new);
		jogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		final Jogador jogadorCapitao = buscarJogadorPorId(idJogador).orElseThrow(JogadorNaoEncontradoException::new);
		final Time timeCapitao = buscarTimePorId(jogadorCapitao.getIdTime()).orElseThrow(TimeNaoEncontradoException::new);
		timeCapitao.setCapitaoId(jogadorCapitao.getId());
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		final Time timeCapitao = buscarTimePorId(idTime).orElseThrow(TimeNaoEncontradoException::new);
		if(timeCapitao.getCapitaoId().equals(null)) throw new CapitaoNaoInformadoException();
		return timeCapitao.getCapitaoId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogadorNome = buscarJogadorPorId(idJogador).orElseThrow(JogadorNaoEncontradoException::new);
		return jogadorNome.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {

		Time timeNome = buscarTimePorId(idTime).orElseThrow(TimeNaoEncontradoException::new);
		return timeNome.getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		buscarTimePorId(idTime).orElseThrow(TimeNaoEncontradoException::new);

		return jogadores
				.stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(i -> i.getId()))
				.map(jogador -> jogador.getIdTime())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		return jogadores
				.stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(i -> i.getNivelHabilidade()))
				.map(jogador -> jogador.getId())
				.collect(Collectors.toCollection());
	}
		Retorna o identificador do melhor jogador do time.

				Long idTime* Identificador do time.
				Exceções:

		Caso o time informado não exista, retornar br.com.codenation.desafio.exceptions.TimeNaoEncontradoException
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		throw new UnsupportedOperationException();
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		throw new UnsupportedOperationException();
	}

	private Optional<Time> buscarTimePorId(Long id) {
		return times
				.stream()
				.filter(time -> time.getId().equals(id))
				.findFirst();
	}

	private Optional<Jogador> buscarJogadorPorId(Long id){
		return jogadores
				.stream()
				.filter(jogador -> jogador.getId().equals(id))
				.findFirst();
	}
}
