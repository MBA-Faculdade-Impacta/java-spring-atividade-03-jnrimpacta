package br.com.impacta.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simular")
public class SimularValoresController {

	@GetMapping
	public ResponseEntity<String> simularValores(@RequestParam(name="codigoProduto") int codigoProduto,
			@RequestParam(name="codTipoPagamento") int codTipoPagamento) {
		/*
		 * Elabore um algoritmo para calcular o valor final de um produto com base em seu valor REAL
		 *  e a condição de pagamento.
		 *  
		 *  A escolha do produto e sua condição de pagamento da-se através de seus códigos, faça um 
		 *  algoritmo também para realizar a escolha de cada um dos itens a partir de seus códigos.
		 *  
		 *  Tabela de produto
		 *  
		 *  CodigoProduto	descrição do Produto		Valor do Produto
		 * 	1				Camisa						70.00
		 * 	2				Shorts						57.50
		 * 	3				Meia						9.99
		 * 	4				Toca						35.00
		 * 	5				Luvas						19.50
		 * 
		 * -----------------------------------------------------------------
		 * 
		 * Tabela de condição de pagamento
		 * 
		 * 	CodTipoPagamento		descrição da condição de pagamento
		 * 	1						A vista no dinheiro com 10% de desconto
		 * 	2						A vista no cartão de crédito  com 5% de desconto
		 * 	3						Em duas parcelas sem nenhum desconto
		 * 	4						Em três vezes com 10% de juros
		 * 
		 * OBS: Considerar sempre os descontos ou juros do valor do produto
		 * A resposta do exercicio deve seguir o seguinte formato:
		 * 
		 * <descrição do produto> sendo pago <descrição da condição de pagamento> custará <valor final do produto> reais
		 * 
		 * Ex.: Camisa sendo pago A vista no dinheiro com 10% de desconto custará 63.00 reais
		 * 
		 */
		
    String desc_produto = "";
    double vlr_prod = 0.00;
    switch(codigoProduto){

      case 1:
        desc_produto = "Camisa";
        vlr_prod = 70.00;
      break;

      case 2:
        desc_produto = "Shorts";
        vlr_prod = 57.50;
      break;

      case 3:
        desc_produto = "Meia";
        vlr_prod = 9.99;
      break;

      case 4:
        desc_produto = "Toca";
        vlr_prod = 35.00;
      break;

      case 5:
        desc_produto = "Luvas";
        vlr_prod = 19.50;
      break;

    }

    String desc_pagamento = "";
    double vlr_final = 0.00;
    String resultado = "";
    switch(codTipoPagamento){

      case 1:
        desc_pagamento = "A vista no dinheiro com 10% de desconto";
        vlr_final = (vlr_prod - (vlr_prod * 0.1));
      break;

      case 2:
        desc_pagamento = "A vista no cartão de crédito  com 5% de desconto";
        vlr_final = (vlr_prod - (vlr_prod * 0.05));
      break;

      case 3:
        desc_pagamento = "Em duas parcelas sem nenhum desconto";
        vlr_final = vlr_prod;
      break;

      case 4:
        desc_pagamento = "Em três vezes com 10% de juros";
        vlr_final = (vlr_prod - (vlr_prod * 0.1));
      break;

    }

    String retorno = desc_produto + " sendo pago " + desc_pagamento + " custará " + vlr_final + " reais"; 
		
		return ResponseEntity.ok(retorno);

	}
	
}
