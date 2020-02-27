package br.com.codenation;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.jogadores.Jogador;
import br.com.codenation.times.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		if (!buscarTimePorId(idTime).isPresent())throw new TimeNaoEncontradoException();

		jogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		final Jogador jogadorCapitao = buscarJogadorPorId(idJogador).orElseThrow(JogadorNaoEncontradoException::new);
		buscarTimePorId(jogadorCapitao.getIdTime()).get().setCapitaoId(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		final Time timeCapitao = buscarTimePorId(idTime).orElseThrow(TimeNaoEncontradoException::new);
		if(timeCapitao.getCapitaoId() == null) throw new CapitaoNaoInformadoException();
		return timeCapitao.getCapitaoId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		return buscarJogadorPorId(idJogador).map(Jogador::getNome).orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		return buscarTimePorId(idTime).map(Time::getNome).orElseThrow(TimeNaoEncontradoException::new);
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		if(!buscarTimePorId(idTime).isPresent()) throw new TimeNaoEncontradoException();

		return jogadores
				.stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.sorted(Comparator.comparingLong(Jogador::getId))
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		if(!buscarTimePorId(idTime).isPresent()) throw new TimeNaoEncontradoException();

		return jogadores
				.stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.min(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
				.get().getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {

		Time time = buscarTimePorId(idTime).orElseThrow(TimeNaoEncontradoException::new);
		return jogadores
				.stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.min(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.orElse(null);
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {

		return times
				.stream()
				.sorted(Comparator.comparing(Time::getId))
				.map(Time::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {

		Time time = buscarTimePorId(idTime).orElseThrow(TimeNaoEncontradoException::new);

		return jogadores.stream()
				.filter(jogador -> jogador.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getId))
				.max(Comparator.comparing(Jogador::getSalario))
				.get().getId();

	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		return buscarJogadorPorId(idJogador)
				.map(Jogador::getSalario)
				.orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		return jogadores
				.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade)
						.reversed()
						.thenComparing(Jogador::getId))
				.map(Jogador::getId)
				.limit(top)
				.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		Optional<Time> time_casa = buscarTimePorId(timeDaCasa), time_fora = buscarTimePorId(timeDeFora);

		if(!time_casa.isPresent() || !time_fora.isPresent()) throw new TimeNaoEncontradoException();

		if(time_casa.get().getCorUniformePrincipal().equals(time_fora.get().getCorUniformePrincipal())){
			return time_fora.get().getCorUniformeSecundario();
		} return time_fora.get().getCorUniformePrincipal();

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
