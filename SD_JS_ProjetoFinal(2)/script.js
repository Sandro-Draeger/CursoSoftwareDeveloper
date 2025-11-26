// Modo Noturno
const modoNoturno = document.getElementById("themeToggle");

modoNoturno.addEventListener("click", () => {
  document.body.classList.toggle("dark-theme");
  modoNoturno.textContent = '🌞' === modoNoturno.textContent ? '🌛' : '🌞';
});

// // Tabela de Despesas
// const form = document.getElementById("expenseForm");
// const tabela = document.getElementById("actions-column");
// const descricao = document.getElementById("description");
// const valor = document.getElementById("amount");
// const categoria = document.getElementById("category");

// form.addEventListener("submit", (e) => {
//   e.preventDefault();

//   const li = document.createElement("tr");
//   const valorNum = parseFloat(valor.value);
//   li.textContent = `${descricao.value} - €${valor.value} - ${categoria.value} `;
//   tabela.appendChild(li);

 
//   let btnRemover = document.createElement("button");
//   btnRemover.textContent = "Remover";
//   btnRemover.style.backgroundColor = "#ff0505ff";
//   li.appendChild(btnRemover);

//   btnRemover.addEventListener("click", function () {
//     removerItem(li, valorNum);
//   });


//   let btnAlterar = document.createElement("button");
//   btnAlterar.textContent = "Alterar";
//   btnAlterar.style.backgroundColor = "#05ff1aff";
//   li.appendChild(btnAlterar);

// btnAlterar.addEventListener("click", function () {
//     inlineEditItem.call(this);
// });

//   atualizarTotal(valorNum);

//   form.reset();
// });
// Elementos
// Elementos
// Elementos
// Elementos
// Seleção de elementos
const form = document.getElementById("expenseForm");
const table = document.getElementById("expenseTable");
const tbody = document.getElementById("expenseTableBody");
const emptyState = document.getElementById("emptyState");

const descriptionInput = document.getElementById("description");
const amountInput = document.getElementById("amount");
const categoryInput = document.getElementById("category");

const totalValueElement = document.getElementById("totalValue");

let total = 0;


form.addEventListener("submit", function (event) {
    event.preventDefault();

    const desc = descriptionInput.value;
    const amount = parseFloat(amountInput.value);
    const category = categoryInput.value;

    addExpense(desc, amount, category);

    form.reset();
});


function addExpense(description, amount, category) {
    emptyState.style.display = "none";
    table.style.display = "table";

    const row = document.createElement("tr");

    // Descrição
    const descCell = document.createElement("td");
    descCell.textContent = description;
    descCell.classList.add("desc");

    // Valor
    const amountCell = document.createElement("td");
    amountCell.textContent = "€ " + amount.toFixed(2);
    amountCell.classList.add("amount");

    // Categoria
    const catCell = document.createElement("td");
    catCell.textContent = category;
    catCell.classList.add("category");

    // Data
    const dateCell = document.createElement("td");
    dateCell.textContent = new Date().toLocaleDateString();

    // Ações
    const actionsCell = document.createElement("td");

    const editButton = document.createElement("button");
    editButton.textContent = "Edit";

    const removeButton = document.createElement("button");
    removeButton.textContent = "Remove";

    actionsCell.appendChild(editButton);
    actionsCell.appendChild(removeButton);

    // Montar linha
    row.appendChild(descCell);
    row.appendChild(amountCell);
    row.appendChild(catCell);
    row.appendChild(dateCell);
    row.appendChild(actionsCell);

    tbody.appendChild(row);

    updateTotal(amount);

    // Eventos
    removeButton.addEventListener("click", function () {
        removeExpense(row, amount);
    });

    editButton.addEventListener("click", function () {
        editExpense(row, amount);
    });
}


function removeExpense(row, amount) {
    row.remove();
    updateTotal(-amount);

    if (tbody.children.length === 0) {
        emptyState.style.display = "block";
        table.style.display = "none";
    }
}


function editExpense(row, oldAmount) {
    const descCell = row.querySelector(".desc");
    const amountCell = row.querySelector(".amount");
    const catCell = row.querySelector(".category");

    const descValue = descCell.textContent;
    const amountValue = parseFloat(amountCell.textContent.replace("€ ", ""));
    const catValue = catCell.textContent;

  
    const descInput = document.createElement("input");
    descInput.type = "text";
    descInput.value = descValue;

    const amountInputField = document.createElement("input");
    amountInputField.type = "number";
    amountInputField.step = "0.01";
    amountInputField.value = amountValue;

    const catInput = document.createElement("input");
    catInput.type = "text";
    catInput.value = catValue;

    descCell.textContent = "";
    descCell.appendChild(descInput);

    amountCell.textContent = "";
    amountCell.appendChild(amountInputField);

    catCell.textContent = "";
    catCell.appendChild(catInput);

    // Alterar botão
    const editButton = row.querySelector("button");
    editButton.textContent = "Save";

    editButton.onclick = function () {
        const newDesc = descInput.value;
        const newAmount = parseFloat(amountInputField.value);
        const newCat = catInput.value;

        descCell.textContent = newDesc;
        amountCell.textContent = "€ " + newAmount.toFixed(2);
        catCell.textContent = newCat;

        updateTotal(newAmount - oldAmount);

        editButton.textContent = "Edit";
        editButton.onclick = function () {
            editExpense(row, newAmount);
        };
    };
}


function updateTotal(value) {
    total += value;
    totalValueElement.textContent = total.toFixed(2);
}
