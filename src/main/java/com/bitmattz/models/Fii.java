package com.bitmattz.models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fiis")
@Getter
@Setter
public class Fii {
    @Id
    @Column(name = "codigo")
    String codigo;

    @Column(name = "setor")
    String setor;

    @Column(name = "preco_atual")
    Double preco_atual;

    @Column(name = "liquidez_diaria")
    Double liquidez_diaria;

    @Column(name = "dividendo")
    Double dividendo;

    @Column(name = "dividend_yield")
    Double Doubledividend_yield;

    @Column(name = "variacao_preco")
    Double variacao_preco;

    @Column(name = "rentabilidade_periodo")
    Double rentabilidade_periodo;

    @Column(name = "rentabilidade_acumulada")
    Double rentabilidade_acumulada;

    @Column(name = "patrimonio_liquido")
    String patrimonio_liquido;

    @Column(name = "vpa")
    Double vpa;

    @Column(name = "p_vpa")
    Double p_vpa;

    @Column(name = "dy_patrimonial")
    Double dy_patrimonial;

    @Column(name = "variacao_patrimonial")
    Double variacao_patrimonial;

    @Column(name = "vacancia_fisica")
    Double vacancia_fisica;

    @Column(name = "vacancia_financeira")
    Double vacancia_financeira;

    @Column(name = "quantidade_de_ativos")
    Integer quantidade_de_ativos;
}
