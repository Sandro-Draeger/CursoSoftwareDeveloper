// Modo Noturno
const modoNoturno = document.getElementById("theme-toggle");

modoNoturno.addEventListener("click", () => {
  document.body.classList.toggle("dark-theme");
  modoNoturno.textContent = '🌞' === modoNoturno.textContent ? '🌛' : '🌞';
});

// Gerenciamento de Despesas
const formulario = document.getElementById("form-despesa");
const listaDespesas = document.getElementById("lista-despesas");

// Evento de submissão do formulário
formulario.addEventListener("submit", function (evento) {
  evento.preventDefault();

  // Obtendo valores do formulário
  const descricao = formulario.elements.descricao.value;
  const valor = formulario.elements.valor.value;
  const selectedCategoria = formulario.elements.categoria.value; 

  // Criando o item da lista
  const item = document.createElement("li");

  // Texto Descrição
  const textoDescricao = document.createElement("span");
  textoDescricao.className = "descricao";
  textoDescricao.textContent = descricao;

  // Texto Valor
  const textoValor = document.createElement("span");
  textoValor.className = "valor";
  textoValor.textContent = `€ ${valor}`;

  // Seleção da categoria
  selectCategoria = document.createElement("select");
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
  selectCategoria.selectedOption = selectedCategoria;

  // Botão Editar
  const botaoEditar = document.createElement("button");
  botaoEditar.type = "button";
  botaoEditar.textContent = "✏️ Editar";

  // Botão Apagar
  const botaoApagar = document.createElement("button");
  botaoApagar.type = "button";
  botaoApagar.textContent = "❌ Excluir";

  // --- LÓGICA DE EDIÇÃO ---
  botaoEditar.addEventListener("click", function () {
    const estaEditando = item.classList.toggle("editando");
    // Alterna entre modos de edição e visualização usando o bolleano estaEditando
    if (estaEditando) {
      textoDescricao.contentEditable = "true";
      textoValor.contentEditable = "true";
      selectCategoria.disabled = false; // Habilita o select
      botaoEditar.textContent = "✔ Salvar";
      // Foca na descrição para facilitar a edição
      textoDescricao.focus();
    } else {
      textoDescricao.contentEditable = "false";
      textoValor.contentEditable = "false";
      selectCategoria.disabled = true; // Desabilita o select
      botaoEditar.textContent = "✏️ Editar";
      //
    
    }
  });

  // --- LÓGICA DE APAGAR ---
  botaoApagar.addEventListener("click", function () {
    item.remove();
  });

  // Monta o item
  item.appendChild(textoDescricao);
  item.appendChild(textoValor);
  item.appendChild(selectCategoria); // Aqui
  item.appendChild(botaoEditar);
  item.appendChild(botaoApagar);

  // Adiciona à lista
  listaDespesas.appendChild(item);

  // Limpa formulário
  formulario.reset();
});
