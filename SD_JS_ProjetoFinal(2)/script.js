// Modo Noturno
const modoNoturno = document.getElementById("theme-toggle");

modoNoturno.addEventListener("click", () => {
  document.body.classList.toggle("dark-theme");
  modoNoturno.textContent = '🌞' === modoNoturno.textContent ? '🌛' : '🌞';
});

// Gerenciamento de Despesas
const formulario = document.getElementById("form-despesa");
const listaDespesas = document.getElementById("lista-despesas");

formulario.addEventListener("submit", function (evento) {
evento.preventDefault();

const descricao = formulario.elements.descricao.value;
const valor = formulario.elements.valor.value;
const categoria = formulario.elements.categoria.value;

// Criando o item da lista
const item = document.createElement("li");

const textoDescricao = document.createElement("span");
textoDescricao.className = "descricao";
textoDescricao.textContent = descricao;

const textoValor = document.createElement("span");
textoValor.className = "valor";
textoValor.textContent = `€ ${valor}`;

// select categoria
const textoCategoria = document.createElement("select");
textoCategoria.className = "categoria";

const option = document.createElement("option");
option.value = categoria;
option.textContent = categoria;
textoCategoria.appendChild(option);

// Botão Editar
const botaoEditar = document.createElement("button");
botaoEditar.type = "button";
botaoEditar.textContent = "Editar";

// Botão Apagar
const botaoApagar = document.createElement("button");
botaoApagar.type = "button";
botaoApagar.textContent = "Apagar";

// --- LÓGICA DE EDIÇÃO INLINE ---
botaoEditar.addEventListener("click", function () {
const estaEditando = item.classList.toggle("editando");

if (estaEditando) {
textoDescricao.contentEditable = "true";
textoValor.contentEditable = "true";
textoCategoria.contentEditable = "true";

botaoEditar.textContent = "Salvar";
textoDescricao.focus();
} else {
textoDescricao.contentEditable = "false";
textoValor.contentEditable = "false";
textoCategoria.contentEditable = "false";

botaoEditar.textContent = "Editar";

console.log("Descrição salva:", textoDescricao.textContent.trim());
console.log("Valor salvo:",
textoValor.textContent.replace("€", "").trim()
);
console.log("Categoria salva:", textoCategoria.textContent.trim());
}
});

// --- LÓGICA DE APAGAR ---
botaoApagar.addEventListener("click", function () {
item.remove();
});

// Monta o item
item.appendChild(textoDescricao);
item.appendChild(textoValor);
item.appendChild(textoCategoria);
item.appendChild(botaoEditar);
item.appendChild(botaoApagar);

// Adiciona à lista
listaDespesas.appendChild(item);

// Limpa formulário
formulario.reset();
});