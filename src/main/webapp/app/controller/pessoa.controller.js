app.controller('pessoaController', pessoaController);

function pessoaController($scope, $http) {

    $scope.salvar = salvar;
    $scope.editar = editar;
    $scope.limpar = limpar;
    $scope.excluir = excluir;

    init();

    function init() {
        listar();
    }


    function salvar() {
        $http.post('api/pessoa', $scope.pessoa).then(salvarResult, salvarError);
        function salvarResult(response) {
            limpar();
            listar();
        }

        function salvarError(response) {
            console.log(response.data);
        }

    }

    function listar() {
        $http.get('api/pessoa').then(listarResult, listarError);
        function listarResult(response) {
            $scope.pessoas = response.data;
        }

        function listarError(response) {
            console.log(response.data);
        }
    }

    function editar(pessoa) {
        $scope.pessoa = pessoa;
    }

    function excluir(id) {
        $http.delete('api/pessoa/'+id).then(excluirResult, excluirError);
        function excluirResult(response) {
            limpar();
            listar();
        }

        function excluirError(response) {
            console.log(response.data);
        }
    }

    function limpar() {
        $scope.pessoa = {};
    }

}
