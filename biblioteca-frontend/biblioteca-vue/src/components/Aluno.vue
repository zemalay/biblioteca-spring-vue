<template>
	<div class="">
		<div class="navbar">
			<welcome></welcome>
		</div>
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Lista dos
							<b>Alunos</b>
						</h2>
					</div>
					<div class="col-sm-6">
						<a v-b-modal.modalAdd href="#addEmployeeModal" class="btn btn-success" data-toggle="modal">
							<i class="material-icons">&#xE147;</i>
							<span>Adiciona Aluno</span>
						</a>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Matricula</th>
						<th>CPF</th>
						<th>Naturalidade</th>
						<th>Endereco</th>
						<th>Telefone</th>
						<th>Email</th>
						<th>Curso</th>
						<th>Ano do Ingresso</th>
						<th>Periodo</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="aluno in alunos" :key="aluno.id">
						<td class="tg-yw4l">{{ aluno.nome }}</td>
						<td class="tg-yw4l">{{ aluno.matricula }}</td>
						<td class="tg-yw4l">{{ aluno.cpf }}</td>
						<td class="tg-yw4l">{{ aluno.naturalidade }}</td>
						<td class="tg-yw4l">{{ aluno.endereco }}</td>
						<td class="tg-yw4l">{{ aluno.telefone }}</td>
						<td class="tg-yw4l">{{ aluno.email }}</td>
						<td class="tg-yw4l">{{ aluno.curso.nome }}</td>
						<td class="tg-yw4l">{{ aluno.anoIngresso }}</td>
						<td class="tg-yw4l">{{ aluno.periodoIngresso }}</td>
						<td>
							<a v-b-modal.modalEdit @click="passFormData(aluno)" href="#" class="edit" data-toggle="modal">
								<i class="material-icons" data-toggle="tooltip" title="Editar">&#xE254;</i>
							</a>
							<a href="#" @click="apagar(aluno.id)" class="delete" data-toggle="modal">
								<i class="material-icons" data-toggle="tooltip" title="Deletar">&#xE872;</i>
							</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- Modal Cadastrar -->
		<b-modal id="modalAdd" ref="modal1" title="Submit your name" @ok="handleOkSave" @shown="clearName">
			<form @submit.stop.prevent="cadastrar">
				<b-form-input type="text" placeholder="Digite o nome " v-model='formAluno.nome'></b-form-input>
				<b-form-input type="text" placeholder="Digite o cpf" v-model='formAluno.cpf'></b-form-input>
				<b-form-input type="text" placeholder="Digite a naturalidade" v-model='formAluno.naturalidade'></b-form-input>
				<b-form-input type="text" placeholder="Digite o endereco" v-model='formAluno.endereco'></b-form-input>
				<b-form-input type="text" placeholder="Digite o telefone" v-model='formAluno.telefone'></b-form-input>
				<b-form-input type="text" placeholder="Digite o email" v-model='formAluno.email'></b-form-input>
				<b-form-input type="text" placeholder="Digite o ano ingresso" v-model='formAluno.anoIngresso'></b-form-input>
				<b-form-input type="text" placeholder="Digite o periodo" v-model='formAluno.periodoIngresso'></b-form-input>
				<model-select :options="options" v-model="item" placeholder="seleciona o curso">
				</model-select>
				<!-- <b-form-select v-model="formCurso.tipo" :options="tipo" class="mb-3"></b-form-select> -->
			</form>
		</b-modal>

		<!-- Modal Editar -->
		<b-modal id="modalEdit" ref="modal2" title="Submit your name" @ok="handleOkEdit">
			<form @submit.stop.prevent="atualizar(formAluno.id)">
				<b-form-input type="text" placeholder="Digite o nome " v-model='formAluno.nome'></b-form-input>
				<b-form-input type="text" placeholder="Digite o cpf" v-model='formAluno.cpf'></b-form-input>
				<b-form-input type="text" placeholder="Digite a naturalidade" v-model='formAluno.naturalidade'></b-form-input>
				<b-form-input type="text" placeholder="Digite o endereco" v-model='formAluno.endereco'></b-form-input>
				<b-form-input type="text" placeholder="Digite o telefone" v-model='formAluno.telefone'></b-form-input>
				<b-form-input type="text" placeholder="Digite o email" v-model='formAluno.email'></b-form-input>
				<b-form-input type="text" placeholder="Digite o ano ingresso" v-model='formAluno.anoIngresso'></b-form-input>
				<b-form-input type="text" placeholder="Digite o periodo" v-model='formAluno.periodoIngresso'></b-form-input>
				<model-select :options="options" v-model="item" placeholder="seleciona o curso">
				</model-select>
				<!-- <b-form-select v-model="formCurso.tipo" :options="tipo" class="mb-3"></b-form-select> -->
			</form>
		</b-modal>

		<!-- Modal Deletar -->

	</div>

</template>

<script>
import axios from 'axios';
import swal from 'sweetalert';
import { ModelSelect } from 'vue-search-select';

export default {
	data() {
		return {
			options: [],
			item: {
				value: '',
				text: ''
			},
			alunos: [],
			curso: {
				id: '',
				nome: ''
			},
			formAluno: {
				id: '',
				nome: '',
				nomeMae: '',
				matricula: '',
				cpf: '',
				rg: '',
				naturalidade: '',
				endereco: '',
				telefone: '',
				email: '',
				senha: '',
				anoIngresso: '',
				periodoIngresso: ''
			}
		};
	},
	beforeMount() {
		this.getAlunos();
		this.getCursos();
	},
	components: {
		ModelSelect,
	},
	methods: {
		getAlunos() {
			axios({ method: 'GET', url: 'http://localhost:8090/aluno/' }).then(
				result => {
					this.alunos = result.data;
				},
				error => {
					console.error(error);
				}
			);
		},
		getCursos() {
			axios({ method: 'GET', url: 'http://localhost:8090/curso/' }).then(
				result => {
					var cursos = result.data;
					for (let curso of cursos) {
						var item = {};
						item.value = curso.id;
						item.text = curso.nome;
						this.options.push(item);
					}
				},
				error => {
					console.error(error);
				}
			);
		},
		passFormData(data) {
			this.formAluno = data;
		},
		clearName() {
			this.formAluno = {};
			this.item = {};
		},
		apagar(id) {
			swal({
				icon: 'warning',
				title: 'Cuidado!',
				text: 'Tem certeza?',
				dangerMode: true,
				buttons: true
			}).then(result => {
				if (!result) throw null;
				axios({
					method: 'DELETE',
					url: 'http://localhost:8090/aluno/' + id
				}).then(
					result => {
						swal({
							title: 'Removido!',
							text: 'O Aluno foi removido!',
							icon: 'success',
							buttons: false,
							timer: 1000
						});
						this.getAlunos();
					},
					error => {
						console.error(error);
					}
				);
			});
		},
		handleOkSave(evt) {
			// Prevent modal from closing
			evt.preventDefault();
			// this.cadastrar();
			if (!this.formAluno.nome) {
			} else {
				// alert(this.formAluno.curso.id);
				// alert(this.item.value);
				this.cadastrar();
			}
		},
		handleOkEdit(evt) {
			// Prevent modal from closing
			evt.preventDefault();
			// this.cadastrar();
			if (!this.formAluno.nome) {
			} else {
				this.atualizar(this.formAluno);
			}
		},
		cadastrar() {
			var curso = {
				id: this.item.value,
				nome: this.item.text
			};
			this.formAluno['curso'] = curso;
			axios({
				method: 'POST',
				url: 'http://localhost:8090/aluno/',
				data: this.formAluno,
				headers: { 'content-type': 'application/json' }
			}).then(
				result => {
					console.log(JSON.stringify(result.data, null, 4));
					axios({ method: 'GET', url: 'http://localhost:8090/aluno/' }).then(
						result => {
							this.alunos = result.data;
							this.$refs.modal1.hide();
							this.clearName();
							swal({
								title: 'Inserido!',
								text: 'O Aluno foi cadastrado!',
								icon: 'success',
								buttons: false,
								timer: 1000
							});
						},
						error => {
							console.error(error);
						}
					);
				},
				error => {
					console.error(error);
				}
			);
		},
		atualizar(data) {
			data.curso.id = this.item.value;
			data.curso.nome = this.item.text;
			axios({
				method: 'PUT',
				url: 'http://localhost:8090/aluno/' + data.id,
				data: data,
				headers: { 'content-type': 'application/json' }
			}).then(
				result => {
					console.log(JSON.stringify(result.data, null, 4));
					axios({ method: 'GET', url: 'http://localhost:8090/aluno/' }).then(
						result => {
							this.alunos = result.data;
							this.$refs.modal2.hide();
							swal({
								title: 'Atualizado!',
								text: 'O aluno foi alterado!',
								icon: 'success',
								buttons: false,
								timer: 1000
							});
						},
						error => {
							console.error(error);
						}
					);
				},
				error => {
					console.error(error);
				}
			);
		}
	}
};
</script>

<style scoped>
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
	font-size: 13px;
}
.table-wrapper {
	background: #fff;
	padding: 20px 25px;
	margin: 30px 0;
	border-radius: 3px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
}
.table-title {
	padding-bottom: 15px;
	background: #435d7d;
	color: #fff;
	padding: 16px 30px;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}
.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}
.table-title .btn-group {
	float: right;
}
.table-title .btn {
	color: #fff;
	float: right;
	font-size: 13px;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}
.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}
.table-title .btn span {
	float: left;
	margin-top: 2px;
}
table.table tr th,
table.table tr td {
	border-color: #e9e9e9;
	padding: 12px 15px;
	vertical-align: middle;
}
/* table.table tr th:first-child {
  width: 60px;
}
table.table tr th:last-child {
  width: 100px;
} */
table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}
table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}
table.table th i {
	font-size: 9px;
	margin: 0 5px;
	cursor: pointer;
}
table.table td:last-child i {
	opacity: 0.9;
	font-size: 20px;
	margin: 0 5px;
}
table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
	text-align: center;
	outline: none !important;
}
table.table td a:hover {
	color: #2196f3;
}
table.table td a.edit {
	color: #ffc107;
}
table.table td a.delete {
	color: #f44336;
}
table.table td i {
	font-size: 19px;
}
table.table .avatar {
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 10px;
}
.pagination {
	float: right;
	margin: 0 0 5px;
}
.pagination li a {
	border: none;
	font-size: 13px;
	min-width: 30px;
	min-height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 2px !important;
	text-align: center;
	padding: 0 6px;
}
.pagination li a:hover {
	color: #666;
}
.pagination li.active a,
.pagination li.active a.page-link {
	background: #03a9f4;
}
.pagination li.active a:hover {
	background: #0397d6;
}
.pagination li.disabled i {
	color: #ccc;
}
.pagination li i {
	font-size: 16px;
	padding-top: 6px;
}
.hint-text {
	float: left;
	margin-top: 10px;
	font-size: 13px;
}
/* Custom checkbox */
.custom-checkbox {
	position: relative;
}
.custom-checkbox input[type='checkbox'] {
	opacity: 0;
	position: absolute;
	margin: 5px 0 0 3px;
	z-index: 9;
}
.custom-checkbox label:before {
	width: 18px;
	height: 18px;
}
.custom-checkbox label:before {
	content: '';
	margin-right: 10px;
	display: inline-block;
	vertical-align: text-top;
	background: white;
	border: 1px solid #bbb;
	border-radius: 2px;
	box-sizing: border-box;
	z-index: 2;
}
.custom-checkbox input[type='checkbox']:checked + label:after {
	content: '';
	position: absolute;
	left: 6px;
	top: 3px;
	width: 6px;
	height: 11px;
	border: solid #000;
	border-width: 0 3px 3px 0;
	transform: inherit;
	z-index: 3;
	transform: rotateZ(45deg);
}
.custom-checkbox input[type='checkbox']:checked + label:before {
	border-color: #03a9f4;
	background: #03a9f4;
}
.custom-checkbox input[type='checkbox']:checked + label:after {
	border-color: #fff;
}
.custom-checkbox input[type='checkbox']:disabled + label:before {
	color: #b8b8b8;
	cursor: auto;
	box-shadow: none;
	background: #ddd;
}
/* Modal styles */
.modal .modal-dialog {
	max-width: 400px;
}
.modal .modal-header,
.modal .modal-body,
.modal .modal-footer {
	padding: 20px 30px;
}
.modal .modal-content {
	border-radius: 3px;
}
.modal .modal-footer {
	background: #ecf0f1;
	border-radius: 0 0 3px 3px;
}
.modal .modal-title {
	display: inline-block;
}
.modal .form-control {
	border-radius: 2px;
	box-shadow: none;
	border-color: #dddddd;
}
.modal textarea.form-control {
	resize: vertical;
}
.modal .btn {
	border-radius: 2px;
	min-width: 100px;
}
.modal form label {
	font-weight: normal;
}
</style>
