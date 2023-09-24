package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

    public class ReajusteServiceTest {

        private ReajusteService service;
        private  Funcionario funcionario;

        @BeforeEach
        public void init() {
            System.out.println("Inicializar");
            this.service = new ReajusteService();
            this.funcionario = new Funcionario("Charles", LocalDate.now(), new BigDecimal ("1000.00"));
        }
        @AfterEach
        public void finalizar() {
            System.out.println("Fim");
        }
        @BeforeAll
        public static void antesDeTodos() {
            System.out.println("Antes de todos");
        }
        @AfterAll
        public static void depoisDeTodos() {
            System.out.println("Depois de todos");
        }
        @Test
        public  void reajusteDeveriaSerDeTresPorCentoQuandoDesenpenhoForADesejar() {

            service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

            assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
        }

        @Test
        public  void reajusteDeveriaSerDeQuinzePorCentoQuandoDesenpenhoForBom() {

            service.concederReajuste(funcionario, Desempenho.BOM);

            assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
        }

        @Test
        public  void reajusteDeveriaSerDeVintePorCentoQuandoDesenpenhoForOtimo() {

            service.concederReajuste(funcionario, Desempenho.OTIMO);

            assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
        }
    }
