<template>

	<!-- <div class="container">
        <b-form-group label="Seleciona ">
            <b-form-select id="tipoTabel" v-model="selected" :options="options" class="mb-3" />
        </b-form-group>
        <div>Selected:
            <strong>{{ selected }}</strong>
        </div>
        <br>
        <span>Selected: {{ selected }}</span>
    </div> -->

	<div class="">
		<!-- Tabela Item -->
		<div class="navbar">
			<welcome></welcome>
		</div>
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Lista dos
							<b>Acervos</b>
						</h2>
					</div>
					<div class="col-sm-6">
						<a v-b-modal.modalAdd href="#addEmployeeModal" class="btn btn-success" data-toggle="modal">
							<i class="material-icons">&#xE147;</i>
							<span>Adiciona Acervo</span>
						</a>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Titulo</th>
						<th>Tipo Item</th>
						<th>ISBN</th>
						<th>Autor</th>
						<th>Editora</th>
						<th>Ano Publicacao</th>
						<th>Nº Paginas</th>
						<th>Edição</th>
						<th>Area</th>
						<th>Data Gravacao</th>
						<th>Data</th>
						<th>Congresso</th>
						<th>Local</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="item in itens" :key="item.id">
						<td class="tg-yw4l">{{ item.titulo }}</td>
						<td class="tg-yw4l">{{ item.tipoItem }}</td>
						<td class="tg-yw4l">{{ item.isbn }}</td>
						<td class="tg-yw4l">{{ item.autor }}</td>
						<td class="tg-yw4l">{{ item.editora }}</td>
						<td class="tg-yw4l">{{ item.anoPublicacao }}</td>
						<td class="tg-yw4l">{{ item.numPagina }}</td>
						<td class="tg-yw4l">{{ item.edicao }}</td>
						<td class="tg-yw4l">{{ item.area }}</td>
						<td class="tg-yw4l">{{ item.dataGravacao }}</td>
						<td class="tg-yw4l">{{ item.data }}</td>
						<td class="tg-yw4l">{{ item.congresso }}</td>
						<td class="tg-yw4l">{{ item.local }}</td>
						<td>
							<a v-b-modal.modalEdit @click="passFormData(item)" href="#" class="edit" data-toggle="modal">
								<i class="material-icons" data-toggle="tooltip" title="Editar">&#xE254;</i>
							</a>
							<a href="#" @click="apagar(item.id)" class="delete" data-toggle="modal">
								<i class="material-icons" data-toggle="tooltip" title="Deletar">&#xE872;</i>
							</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- Modal Cadastrar -->
		<b-modal id="modalAdd" ref="modal1" title="Formulario do Acervo" @ok="handleOkSave" @shown="clearName">
			<form @submit.stop.prevent="cadastrar">
				<b-form-group label="Seleciona o tipo do Acervo">
					<b-form-select id="itemSelect" v-model="itemSelected" :options="tipoItens" class="mb-3" />
				</b-form-group>
				<b-form-group v-if="itemSelected === 'MIDIA' " label="Seleciona o tipo da Midia">
					<b-form-select id="itemSelect" v-model="midiaSelected" :options="tipoMidias" class="mb-3" />
				</b-form-group>
				<b-form-group v-if="itemSelected === 'ANAIS' " label="Seleciona o tipo do ANAIS">
					<b-form-select id="itemSelect" v-model="anaisSelected" :options="tipoAnais" class="mb-3" />
				</b-form-group>
				<b-form-group v-if="itemSelected === 'TRABALHOCONCLUSAO' " label="Seleciona o tipo do Trabalho Conclusao">
					<b-form-select id="itemSelect" v-model="trabalhoSelected" :options="tipoTrabalho" class="mb-3" />
				</b-form-group>
				<b-form-input type="text" placeholder="Digite o titulo " v-model='formItem.titulo'></b-form-input>
				<b-form-input type="text" placeholder="Digite o isbn " v-if="itemSelected === 'LIVRO'" v-model='formItem.isbn'></b-form-input>
				<b-form-input type="text" placeholder="Digite nome do autor " v-if="itemSelected === 'LIVRO' || itemSelected === 'ANAIS' || itemSelected === 'TRABALHOCONCLUSAO'" v-model='formItem.autor'></b-form-input>
				<b-form-input type="number" placeholder="Digite o ano da publicacao " v-if="itemSelected === 'LIVRO' || itemSelected === 'ANAIS' || itemSelected === 'TRABALHOCONCLUSAO'" v-model='formItem.anoPublicacao'></b-form-input>
				<b-form-input type="number" placeholder="Digite numero das paginas " v-if="itemSelected === 'LIVRO' || itemSelected === 'REVISTA'" v-model='formItem.numPagina'></b-form-input>
				<b-form-input type="number" placeholder="Digite a edicao " v-if="itemSelected === 'LIVRO' || itemSelected === 'REVISTA' || itemSelected === 'JORNAL'" v-model='formItem.edicao'></b-form-input>
				<b-form-input type="text" placeholder="Digite a area " v-if="itemSelected === 'LIVRO'" v-model='formItem.area'></b-form-input>
				<b-form-input type="date" placeholder="Insere a data gravacao " v-if="itemSelected === 'MIDIA'" v-model='formItem.dataGravacao'></b-form-input>
				<b-form-input type="date" placeholder="Insere a data " v-if="itemSelected === 'REVISTA' || itemSelected === 'JORNAL'" v-model='formItem.data'></b-form-input>
				<b-form-input type="text" placeholder="Digite o congresso " v-if="itemSelected === 'ANAIS'" v-model='formItem.congresso'></b-form-input>
				<b-form-input type="text" placeholder="Digite o local " v-if="itemSelected === 'TRABALHOCONCLUSAO' || itemSelected === 'ANAIS' || itemSelected === 'TRABALHOCONCLUSAO'" v-model='formItem.local'></b-form-input>
				<b-form-input type="text" placeholder="Digite a editora " v-if="itemSelected === 'LIVRO' || itemSelected === 'REVISTA'" v-model='formItem.editora'></b-form-input>
			</form>
		</b-modal>

		<!-- Modal Editar -->
		<b-modal id="modalEdit" ref="modal2" @ok="handleOkEdit">
			<form @submit.stop.prevent="atualizar(formItem.id)">
				<b-form-group label="Seleciona o tipo do Acervo">
					<b-form-select id="itemSelect" v-model="itemSelected" :options="tipoItens" class="mb-3" />
				</b-form-group>
				<b-form-group v-if="itemSelected === 'MIDIA' " label="Seleciona o tipo da Midia">
					<b-form-select id="itemSelect" v-model="midiaSelected" :options="tipoMidias" class="mb-3" />
				</b-form-group>
				<b-form-group v-if="itemSelected === 'ANAIS' " label="Seleciona o tipo do ANAIS">
					<b-form-select id="itemSelect" v-model="anaisSelected" :options="tipoAnais" class="mb-3" />
				</b-form-group>
				<b-form-group v-if="itemSelected === 'TRABALHOCONCLUSAO' " label="Seleciona o tipo do Trabalho Conclusao">
					<b-form-select id="itemSelect" v-model="trabalhoSelected" :options="tipoTrabalho" class="mb-3" />
				</b-form-group>
				<b-form-input type="text" placeholder="Digite o titulo " v-model='formItem.titulo'></b-form-input>
				<b-form-input type="text" placeholder="Digite o isbn " v-if="itemSelected === 'LIVRO'" v-model='formItem.isbn'></b-form-input>
				<b-form-input type="text" placeholder="Digite nome do autor " v-if="itemSelected === 'LIVRO' || itemSelected === 'ANAIS' || itemSelected === 'TRABALHOCONCLUSAO'" v-model='formItem.autor'></b-form-input>
				<b-form-input type="number" placeholder="Digite o ano da publicacao " v-if="itemSelected === 'LIVRO' || itemSelected === 'ANAIS' || itemSelected === 'TRABALHOCONCLUSAO'" v-model='formItem.anoPublicacao'></b-form-input>
				<b-form-input type="number" placeholder="Digite numero das paginas " v-if="itemSelected === 'LIVRO' || itemSelected === 'REVISTA'" v-model='formItem.numPagina'></b-form-input>
				<b-form-input type="number" placeholder="Digite a edicao " v-if="itemSelected === 'LIVRO' || itemSelected === 'REVISTA' || itemSelected === 'JORNAL'" v-model='formItem.edicao'></b-form-input>
				<b-form-input type="text" placeholder="Digite a area " v-if="itemSelected === 'LIVRO'" v-model='formItem.area'></b-form-input>
				<b-form-input type="date" placeholder="Insere a data gravacao " v-if="itemSelected === 'MIDIA'" v-model='formItem.dataGravacao'></b-form-input>
				<b-form-input type="date" placeholder="Insere a data " v-if="itemSelected === 'REVISTA' || itemSelected === 'JORNAL'" v-model='formItem.data'></b-form-input>
				<b-form-input type="text" placeholder="Digite o congresso " v-if="itemSelected === 'ANAIS'" v-model='formItem.congresso'></b-form-input>
				<b-form-input type="text" placeholder="Digite o local " v-if="itemSelected === 'TRABALHOCONCLUSAO' || itemSelected === 'ANAIS' || itemSelected === 'TRABALHOCONCLUSAO'" v-model='formItem.local'></b-form-input>
				<b-form-input type="text" placeholder="Digite a editora " v-if="itemSelected === 'LIVRO' || itemSelected === 'REVISTA'" v-model='formItem.editora'></b-form-input>
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
			itens: [],
			tipoItens: [
				{ value: 'LIVRO', text: 'Livro' },
				{ value: 'ANAIS', text: 'Anais de Congresso' },
				{ value: 'REVISTA', text: 'Revista' },
				{ value: 'JORNAL', text: 'Jornal' },
				{ value: 'TRABALHOCONCLUSAO', text: 'Trabalho de Conclusao' },
				{ value: 'MIDIA', text: 'Midia' }
			],
			tipoMidias: ['CD', 'DVD'],
			tipoAnais: ['ARTIGO', 'POSTER', 'ARTIGO'],
			tipoTrabalho: ['TCC', 'DISSERTACAO', 'TESE'],
			itemSelected: null,
			midiaSelected: null,
			anaisSelected: null,
			trabalhoSelected: null,
			formItem: {
				id: '',
				titulo: '',
				tipoItem: null,
				tipoAnais: null,
				tipoMidia: null,
				tipoTrabalho: null,
				isbn: '',
				autor: '',
				editora: '',
				anoPublicacao: '',
				numPagina: '',
				edicao: '',
				area: '',
				dataGravacao: '',
				data: '',
				congresso: '',
				local: '',
				editora: ''
			}
		};
	},
	beforeMount() {
		this.getItens();
	},
	components: {
		ModelSelect
	},
	methods: {
		getItens() {
			axios({ method: 'GET', url: 'http://localhost:8090/item/' }).then(
				result => {
					this.itens = result.data;
				},
				error => {
					console.error(error);
				}
			);
		},
		passFormData(data) {
			this.formItem = data;
			this.itemSelected = this.formItem.tipoItem;
			this.midiaSelected = this.formItem.tipoMidia;
			this.anaisSelected = this.formItem.tipoAnais;
			this.trabalhoSelected = this.formItem.tipoTrabalho;
		},
		clearName() {
			this.formItem = {};
			this.itemSelected = null;
			this.midiaSelected = null;
			this.anaisSelected = null;
			this.trabalhoSelected = null;
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
					url: 'http://localhost:8090/item/' + id
				}).then(
					result => {
						swal({
							title: 'Removido!',
							text: 'O Acervo foi removido!',
							icon: 'success',
							buttons: false,
							timer: 1000
						});
						this.getItens();
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
			if (!this.formItem.titulo) {
			} else {
				this.cadastrar();
			}
		},
		handleOkEdit(evt) {
			// Prevent modal from closing
			evt.preventDefault();
			// this.cadastrar();
			if (!this.formItem.titulo) {
			} else {
				// console.log(this.formItem);
				this.atualizar(this.formItem);
			}
		},
		cadastrar() {
			this.formItem.tipoItem = this.itemSelected;
			if (this.midiaSelected) {
				this.formItem.tipoMidia = this.midiaSelected;
			} else if (this.anaisSelected) {
				this.formItem.tipoAnais = this.anaisSelected;
			} else if (this.trabalhoSelected) {
				this.formItem.tipoTrabalho = this.trabalhoSelected;
			}
			console.log(this.formItem);
			axios({
				method: 'POST',
				url: 'http://localhost:8090/item/',
				data: this.formItem,
				headers: { 'content-type': 'application/json' }
			}).then(
				result => {
					console.log(JSON.stringify(result.data, null, 4));
					axios({ method: 'GET', url: 'http://localhost:8090/item/' }).then(
						result => {
							this.itens = result.data;
							this.$refs.modal1.hide();
							this.clearName();
							swal({
								title: 'Inserido!',
								text: 'O Item foi cadastrado!',
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
			for (var key in data) {
				if (data[key] == null ) delete data[key];
			}
			console.log(data);
			axios({
				method: 'PUT',
				url: 'http://localhost:8090/item/' + data.id,
				data: data,
				headers: { 'content-type': 'application/json' }
			}).then(
				result => {
					console.log(JSON.stringify(result.data, null, 4));
					axios({ method: 'GET', url: 'http://localhost:8090/item/' }).then(
						result => {
							this.itens = result.data;
							this.$refs.modal2.hide();
							swal({
								title: 'Atualizado!',
								text: 'O Acervo foi alterado!',
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
