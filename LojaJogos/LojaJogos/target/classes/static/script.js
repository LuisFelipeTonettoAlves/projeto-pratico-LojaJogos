const url = "http://localhost:8080/jogos"
function salvar(){
    const jogo={
        nome: document.getElementById("nome").value,
        preco: parseFloat(document.getElementById("preco").value),
        categoria: document.getElementById("categoria").value,
        codigoAtivacao: document.getElementById("codigoAtivacao").value
    };

    fetch (url, {method: "POST", headers:{"Content-Type":"application/json"}, body: JSON.stringify(jogo)}).then(() => listar());
}

function listar(){
    fetch(url)
        .then(res => res.json())
        .then(dados => {
            const lista = document.getElementById("lista");
            lista.innerHTML = "";

        dados.forEach(jogos => {
        const li = document.createElement("li");
        li.innerText = `${jogo.nome} - ${jogo.preco} - ${jogo.categoria}`;
        lista.appendChild(li);
        });
        });
}

listar();