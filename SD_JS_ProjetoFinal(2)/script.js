// Modo Noturno
const modoNoturno = document.getElementById("modo-noturno");

modoNoturno.addEventListener("click", () => {
  document.body.classList.toggle("dark");
});

// Tabela de Despesas
const form = document.getElementById("formDespesas");
const tabela = document.getElementById("tabelaDespesas");
const descricao = document.getElementById("descricao");
const valor = document.getElementById("valor");
const categoria = document.getElementById("categoria");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  const li = document.createElement("li");
  const valorNum = parseFloat(valor.value);
  li.textContent = `${descricao.value} - €${valor.value} - ${categoria.value} `;
  tabela.appendChild(li);

 
  let btnRemover = document.createElement("button");
  btnRemover.textContent = "Remover";
  btnRemover.style.backgroundColor = "#ff0505ff";
  li.appendChild(btnRemover);

  btnRemover.addEventListener("click", function () {
    removerItem(li, valorNum);
  });


  let btnAlterar = document.createElement("button");
  btnAlterar.textContent = "Alterar";
  btnAlterar.style.backgroundColor = "#05ff1aff";
  li.appendChild(btnAlterar);

btnAlterar.addEventListener("click", function () {
    inlineEditItem.call(this);
});

  atualizarTotal(valorNum);

  form.reset();
});

// remover itens
function removerItem(li, valor) {
  tabela.removeChild(li);
  atualizarTotal(-valor);
}

function alterarItem() {
   
    const li = this.parentElement;

    descricao.value = li.dataset.descricao;
    valor.value = li.dataset.valor;
    categoria.value = li.dataset.categoria;

    tabela.removeChild(li);

    atualizarTotal(-parseFloat(li.dataset.valor));
}



//atualiza o valor total
function atualizarTotal(valor) {
  let totalPreco = document.getElementById('totalGasto');
  let totalAtual = parseFloat(totalPreco.textContent.replace('€','')) || 0;
  let novoTotal = totalAtual + parseFloat(valor);
  totalPreco.textContent = `€${novoTotal.toFixed(2)}`;
}

