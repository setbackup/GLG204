<template>
    <Menu />
    <table class="table is-fullwidth">
        <thead>
            <tr>
                <th>Nom de la campagne</th>
                <th>Date debut</th>
                <th>Date fin</th>
                <th>objectif</th>
                <th>Consulter</th>
                <th>Supprimer</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="campagneDons in campagnesDons" :key="campagneDons.name">
                <td>{{ campagneDons.nom }}</td>
                <td>{{ campagneDons.date_debut }}</td>
                <td>{{ campagneDons.date_fin }}</td>
                <td>{{ campagneDons.objectif }}</td>
                <td>
                    <RouterLink :to='"/admin/campagne_dons/details/"+campagneDons.id' >
                        <img width="25" height="25" src="../../assets/loupe.png" />
                    </RouterLink></td>
                <td>
                    <a @click="supprime(campagneDons.id)">
                        <img width="25" height="25" src="../../assets/corbeille.png" />
                    </a>
                </td>
            </tr>
        </tbody>
    </table>
</template>

<script>

import Menu from '@/admin/components/Menu.vue'
import router from '@/router/router';
import axios from 'axios';
import { useRouter } from 'vue-router';

export default{
    name: 'CampagneDonsConsulter',
    data(){
        const router = useRouter();
        return {
            deleteCampagne :'',
            campagnesDons : []
        }
    },
    methods: {
        supprime(id){
            console.log("id de la campagne" + id);
            axios.delete('http://localhost:8080/campagnes_dons/supprimer/'+id,{
                headers:{
                       "Content-Type" : "application/json",
                       "Authorization" : "bearer "+localStorage.getItem('jeton')
                   } 
            }).then(response=>{
                console.log("Supprime OK");
                router.go();
            })
        }
    },
    mounted(){
        axios.get('http://localhost:8080/campagnes_dons/consulter', {
                   headers:{
                       "Content-Type" : "application/json",
                       "Authorization" : "bearer "+localStorage.getItem('jeton')
                   } 
           }).then(response => {
                   if(response.status == 200){
                       this.campagnesDons = response.data;
                   }
           })
    },
    components:{
        Menu
    }
}
</script>