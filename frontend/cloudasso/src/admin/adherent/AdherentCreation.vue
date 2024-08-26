<template>
    <Menu />
    <div class="container">
        <div class="columns">
            <div class="column is-three-fifths is-offset-one-fifth">
                <form class="box" @submit.prevent="addAdhesion">
                    <div class="field">
                        <label class="label">Nom</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Nom" v-model="adhesion.nom" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Prenom</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Prenom" v-model="adhesion.prenom" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Email</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Email" v-model="adhesion.email" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Password</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Password" v-model="adhesion.password" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Adresse</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Adresse" v-model="adhesion.adresse" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Ville</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Ville" v-model="adhesion.ville" />
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Code postal</label>
                        <div class="control has-icons-left has-icons-right">
                            <input class="input" type="text" placeholder="Code postal" v-model="adhesion.code_postal" />
                        </div>
                    </div>
                    <button class="button is-info is-outlined" type="submit">Adhesion</button>
                </form>
            </div>
        </div>
    </div>
</template>


<script>
import axios from 'axios'
import Menu from '@/admin/components/Menu.vue'

export default{
    name: 'AdherentCreation',
    data(){
        return {
            adhesion:{
                nom : '',
                prenom : '',
                email : '',
                password : '',
                adresse : '',
                code_postal : '',
                ville : ''
            }
        }
    },
    methods:{
        addAdhesion(){
            
            console.log(this.adhesion);

            

            axios.post('http://localhost:8080/admin/adherent',this.adhesion,{
                headers:{
                    "Access-Control-Allow-Origin":"*",
                    "Content-Type" : "application/json",
                    "Accept" : "*/*",
                    "Authorization" : "bearer "+localStorage.getItem('jeton')
                }
            }).then(response => {
                console.log(response);
            })
        } 
    },
    components:{
        Menu
    }
}
</script>