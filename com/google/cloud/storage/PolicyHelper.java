package com.google.cloud.storage;

import com.google.api.services.storage.model.Policy.Bindings;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.Policy.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

class PolicyHelper {
   static Policy convertFromApiPolicy(com.google.api.services.storage.model.Policy apiPolicy) {
      Builder policyBuilder = Policy.newBuilder();
      Iterator var2 = apiPolicy.getBindings().iterator();

      while(var2.hasNext()) {
         Bindings binding = (Bindings)var2.next();
         Iterator var4 = binding.getMembers().iterator();

         while(var4.hasNext()) {
            String member = (String)var4.next();
            policyBuilder.addIdentity(Role.of(binding.getRole()), Identity.valueOf(member), new Identity[0]);
         }
      }

      return policyBuilder.setEtag(apiPolicy.getEtag()).build();
   }

   static com.google.api.services.storage.model.Policy convertToApiPolicy(Policy policy) {
      List bindings = new ArrayList(policy.getBindings().size());
      Iterator var2 = policy.getBindings().entrySet().iterator();

      while(var2.hasNext()) {
         Entry entry = (Entry)var2.next();
         List members = new ArrayList(((Set)entry.getValue()).size());
         Iterator var5 = ((Set)entry.getValue()).iterator();

         while(var5.hasNext()) {
            Identity identity = (Identity)var5.next();
            members.add(identity.strValue());
         }

         bindings.add((new Bindings()).setMembers(members).setRole(((Role)entry.getKey()).getValue()));
      }

      return (new com.google.api.services.storage.model.Policy()).setBindings(bindings).setEtag(policy.getEtag());
   }

   private PolicyHelper() {
   }
}
