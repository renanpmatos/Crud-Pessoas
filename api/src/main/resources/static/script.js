// read -------------------------------------------------------------------------------- //

function loadIntoTable(){
    fetch("http://localhost:8080/api/pessoas")
    .then((data) => {
      return data.json(); //convert to object
    })
    .then((objectData) => {
      let tableData = "";
      objectData.map((values) => {
        if(values.cnpj == null){
          values.cnpj = "";
        }
        if(values.cpf == null){
          values.cpf = "";
        }
        tableData += `
              <tr>
                  <td>${values.nome}</td>
                  <td>${values.cpf}</td>
                  <td>${values.cnpj}</td>
                  <td>${values.email}</td>
                  <td>
                    <div class="dropdown">
                      <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false"/>
                      <ul class="dropdown-menu">
                          <li><a class="dropdown-item" onclick="update(${values.id})">Editar</a></li>
                          <li><a class="dropdown-item" onclick="excluir(${values.id})">Excluir</a></li>
                      </ul>
                    </div>
                  </td>
              </tr>
          `;
      });
      const tbody = (document.querySelector("tbody").innerHTML = tableData);
    })
    .catch((err) => {
      console.log(err);
    });
}

function excluir(id) {
    fetch("http://localhost:8080/api/pessoas/" + id, {
      method: "DELETE",
    })
    .then((response) => {
      this.loadIntoTable();
    })
}

function update(id) {
  window.location.replace("./update.html?" + id);
}


function filtrarTable(query) {

  fetch("http://localhost:8080/api/pessoas/pesquisa?query=" + query)
    .then((data) => {
      return data.json(); //convert to object
    })
    .then((objectData) => {
      let tableData = "";
      objectData.map((values) => {
        if(values.cnpj == null){
          values.cnpj = "";
        }
        if(values.cpf == null){
          values.cpf = "";
        }
        tableData += `
          <tr>
              <td>${values.nome}</td>
              <td>${values.cpf}</td>
              <td>${values.cnpj}</td>
              <td>${values.email}</td>
              <td>
                <div class="dropdown">
                  <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false"/>
                  <ul class="dropdown-menu">
                      <li><a class="dropdown-item" onclick="update(${values.id})">Editar</a></li>
                      <li><a class="dropdown-item" onclick="excluir(${values.id})">Excluir</a></li>
                  </ul>
                </div>
              </td>
          </tr>
      `;
      });
      const tbody = (document.querySelector("tbody").innerHTML = tableData);
    })
    .catch((err) => {
      console.log(err);
    });
}

// update -------------------------------------------------------------------------------- //

function carregar(id) {

    fetch("http://localhost:8080/api/pessoas/" + id)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        $("#inputName").val(data.nome);
        $("#inputEmail").val(data.email);
        $("#selectPessoa").val(data.tipo);
        TipoPessoaAlterar();
        $("#inputCPF").val(data.cpf);
        $("#inputCNPJ").val(data.cnpj);
        $("#inputCEP").val(data.cep);
        $("#endereco").val(data.endereco);
        $("#logradouro").val(data.logradouro);
        $("#bairro").val(data.bairro);
        $("#cidade").val(data.cidade);
        $("#UF").val(data.estado);
      });
}

//cadastra pessoa
  function salvar(id) {
    fetch("http://localhost:8080/api/pessoas", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "PUT",
      body: JSON.stringify({
        id: id,
        nome: $("#inputName").val(),
        email: $("#inputEmail").val(),
        tipo: $("#selectPessoa").val(),
        cpf: $("#inputCPF").val(),
        cnpj: $("#inputCNPJ").val(),
        cep: $("#inputCEP").val(),
        endereco: $("#endereco").val(),
        logradouro: $("#logradouro").val(),
        bairro: $("#bairro").val(),
        cidade: $("#cidade").val(),
        estado: $("#UF").val(),
      }),
    })
      .then((response) => response.json())
      .catch(function (res) {
        console.log(res);
      });
    clearForm();
    window.location.replace("./read.html");
}

//muda o tipo de pessoa na Alteração
function TipoPessoaAlterar() {
  var select = document.getElementById("selectPessoa");
  var cnpj = document.getElementById("cnpj");
  var cpf = document.getElementById("cpf");

  const inputCNPJ = document.getElementById("inputCNPJ");
  const inputCPF = document.getElementById("inputCPF");
  switch (select.value) {
    case "Pessoa Física":
      cpf.style.display = "block";
      cnpj.style.display = "none";
      inputCPF.removeAttribute("disabled");
      inputCPF.setAttribute("required", "");
      inputCNPJ.removeAttribute("required");
      inputCNPJ.setAttribute("disabled", "");
      $("#inputCNPJ").val("");
      break;
    case "Pessoa Jurídica":
      cpf.style.display = "none";
      cnpj.style.display = "block";
      inputCNPJ.removeAttribute("disabled");
      inputCNPJ.setAttribute("required", "");
      inputCPF.removeAttribute("required");
      inputCPF.setAttribute("disabled", "");
      $("#inputCPF").val("");
      break;
  }
}

  //limpar form
function clearForm() {
    $("#inputName").val("");
    $("#inputEmail").val("");
    $("#inputCPF").val("");
    $("#inputCNPJ").val("");
    $("#inputCEP").val("");
    $("#endereco").val("");
    $("#logradouro").val("");
    $("#cidade").val("");
    $("#bairro").val("");
    $("#UF").val("");
}

// create -------------------------------------------------------------------------------- //

//cadastra pessoa
function cadastrar() {
  fetch("http://localhost:8080/api/pessoas", {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify({
      nome: $("#inputName").val(),
      email: $("#inputEmail").val(),
      tipo: $("#selectPessoa").val(),
      cpf: $("#inputCPF").val(),
      cnpj: $("#inputCNPJ").val(),
      cep: $("#inputCEP").val(),  
      endereco: $("#endereco").val(),
      logradouro: $("#logradouro").val(),
      bairro: $("#bairro").val(),
      cidade: $("#cidade").val(),
    }),
  })
    .then(function (res) {
      console.log(res);
    })
    .catch(function (res) {
      console.log(res);
    });
  clearForm();
  window.location.replace("./read.html");
}

//muda o tipo de pessoa no Cadastro
function TipoPessoaCadastro() {
  var select = document.getElementById("selectPessoa");
  var cnpj = document.getElementById("cnpj");
  var cpf = document.getElementById("cpf");
  var selecione = document.getElementById("selecione");

  const inputCNPJ = document.getElementById("inputCNPJ");
  const inputCPF = document.getElementById("inputCPF");
  switch (select.value) {
    case "Selecione":
        cpf.style.display = "none";
        cnpj.style.display = "none";
        $("#inputCFP").val(null);
        $("#inputCNPJ").val(null);
        inputCPF.setAttribute("required", "");
        inputCNPJ.setAttribute("required", "");
        break;
    case "Pessoa Física":
      selecione.style.display = "none";
      cpf.style.display = "block";
      cnpj.style.display = "none";
      inputCPF.removeAttribute("disabled");
      inputCPF.setAttribute("required", "");
      inputCNPJ.removeAttribute("required");
      inputCNPJ.setAttribute("disabled", "");
      $("#inputCNPJ").val("");
      break;
    case "Pessoa Jurídica":
      selecione.style.display = "none";
      cpf.style.display = "none";
      cnpj.style.display = "block";
      inputCNPJ.removeAttribute("disabled");
      inputCNPJ.setAttribute("required", "");
      inputCPF.removeAttribute("required");
      inputCPF.setAttribute("disabled", "");
      $("#inputCPF").val("");
      break;
  }
}