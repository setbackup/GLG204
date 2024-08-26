<template>
    <Menu />
    <table class="table is-fullwidth">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Email</th>
                <th>Adresse</th>
                <th>Ville</th>
                <th>Code Postal</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="adherent in adherents" :key="adherent.id">
                <td>{{ adherent.nom }}</td>
                <td>{{ adherent.prenom }}</td>
                <td>{{ adherent.email }}</td>
                <td>{{ adherent.adresse }}</td>
                <td>{{ adherent.ville }}</td>
                <td>{{ adherent.code_postal }}</td>
                <td>
                    <RouterLink :to='"/admin/adherent/details/"+adherent.id' >
                        <img width="25" height="25" src="../../assets/loupe.png" />
                    </RouterLink></td>
                <td>
                    <a @click="supprime" >
                        <img width="25" height="25" src="../../assets/corbeille.png" />
                    </a>
                </td>
            </tr>
        </tbody>
    </table>
</template>

<script>
import axios from 'axios'
import Menu from '@/admin/components/Menu.vue'

export default{
    name: 'AdherentConsulter',
    data(){
        return {
            adherents : []
        }
    },
    mounted(){
        axios.get('http://localhost:8080/admin/adherent', {
                   headers:{
                       "Content-Type" : "application/json",
                       "Authorization" : "bearer "+localStorage.getItem('jeton')
                   } 
           }).then(response => {
                   if(response.status == 200){
                       this.adherents = response.data;
                   }
           })
    },
    components:{
        Menu
    }
}
</script>