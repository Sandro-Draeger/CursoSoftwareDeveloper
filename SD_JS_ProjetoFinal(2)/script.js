// Modo Noturno
const modoNoturno = document.getElementById("theme-toggle");

modoNoturno.addEventListener("click", () => {
  document.body.classList.toggle("dark-theme");
  modoNoturno.textContent = '🌞' === modoNoturno.textContent ? '🌛' : '🌞';
});

// Gerenciamento de Despesas
const formulario = document.getElementById("form-despesa");
const listaDespesas = document.getElementById("lista-despesas");


// Envio do formulário
formulario.addEventListener("submit", function (evento) {
  evento.preventDefault();

  // Criando o item da lista
  const item = document.createElement("li");

  // Capturando os valores do formulário
  const descricao = formulario.elements.descricao.value;
const valor = formulario.elements.valor.value;
const selectedCategoria = formulario.elements.categoria.value; 

  // Texto Descrição
  const textoDescricao = document.createElement("span");
  textoDescricao.className = "descricao";
  textoDescricao.textContent = descricao;

  // Texto Valor
  const textoValor = document.createElement("span");
  textoValor.className = "valor";
  textoValor.textContent = valor;
  textoValor.dataset.valor = parseFloat(valor); // Armazena o valor para calcular o total

  // Seleção da categoria
  const selectCategoria = document.createElement("select");
  selectCategoria.className = "categoria";
  selectCategoria.disabled = true;
  selectCategoria.innerHTML = `
    <option value="alimentacao">Alimentação</option>
    <option value="trasnporte">Transporte</option>
    <option value="entreterimento">Entreterimento</option>
    <option value="compras">Compras</option>
    <option value="contas">Contas</option>
    <option value="saude">Saúde</option>
    <option value="outros">Outros</option>
  `;
  selectCategoria.value = selectedCategoria;

  // Botão Editar
  const botaoEditar = document.createElement("button");
  botaoEditar.type = "button";
  botaoEditar.textContent = "✏️";

  // Botão Apagar
  const botaoApagar = document.createElement("button");
  botaoApagar.type = "button";
  botaoApagar.textContent = "❌";

  // Função Editar
  botaoEditar.addEventListener("click", function () {
    const estaEditando = item.classList.toggle("editando");
    // Alterna entre modos de edição e visualização usando o bolleano estaEditando
    if (estaEditando) {
      textoDescricao.contentEditable = "true";
      textoValor.contentEditable = "true";
      textoValor.dataset.valor = parseFloat(valor); // Armazena o valor para calcular o total
     
      selectCategoria.disabled = false; // Habilita o select
      botaoEditar.textContent = "✔";
      atualizarTotal();
     
    } else {
      textoDescricao.contentEditable = "false";
      textoValor.contentEditable = "false";
      selectCategoria.disabled = true; // Desabilita o select
      botaoEditar.textContent = "✏️";
    }
    
  });

  // função Apagar
  botaoApagar.addEventListener("click", function () {
    item.remove();
    atualizarTotal();
  });

  // Monta o item
  item.appendChild(textoDescricao);
  item.appendChild(textoValor);
  item.appendChild(selectCategoria);
  item.appendChild(botaoEditar);
  item.appendChild(botaoApagar);

  // Adiciona à lista
  listaDespesas.appendChild(item);

  // Cálculo do Total
  atualizarTotal();

  // Limpa formulário
  formulario.reset();
});

// Função para atualizar o total das despesas
const totalValor = document.querySelector('#totalDespesas');

function atualizarTotal() {
  let total = 0;
  //  Percorre os itens da lista e soma os valores
  for (const item of listaDespesas.children) {
    // Pega o valor do dataset e converte para número
    const valorItem = Number.parseFloat(item.querySelector('.valor').dataset.valor);
    total += valorItem;
  }
  // Atualiza o texto do total
  totalValor.textContent = `€ ${total.toFixed(2)}`;
}

// Filtro por categoria
const filtroCategoria = document.querySelector('#filtroCategoria');

filtroCategoria.addEventListener('change', function() {
  // Obtém a categoria selecionada no filtro
  const categoriaSelecionada = filtroCategoria.value; 
  // Percorre os itens da lista e ajusta a visibilidade
  for (const item of listaDespesas.children) {
    //chamar função e adicionar 
    const categoriaItem = item.querySelector('.categoria').value;
    // Verifica se o item deve ser exibido
    if (categoriaSelecionada === '' || categoriaItem === categoriaSelecionada) {
      item.style.display = ''; // Exibe o item
    } else {
      item.style.display = 'none'; // Oculta o item
    }   
  }
});


const dataHoraAtual = document.getElementById("data-hora-atual");

function atualizarDataHora() {
  const opcoes = { 
    year: 'numeric', 
    month: 'long', 
    day: 'numeric', 
    hour: '2-digit', 
    minute: '2-digit' 
  };

  const dataAtualFormatada = new Date().toLocaleString('pt-PT', opcoes);
  dataHoraAtual.textContent = dataAtualFormatada;
}

atualizarDataHora();

setInterval(atualizarDataHora, 60000);
