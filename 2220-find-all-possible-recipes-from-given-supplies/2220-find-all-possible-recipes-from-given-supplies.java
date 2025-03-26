import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> sup = new HashSet<>(Arrays.asList(supplies)); // Convert supplies to HashSet
        HashMap<String, List<String>> making = new HashMap<>(); // Recipe -> Ingredients
        HashSet<String> pans = new HashSet<>(); 
        List<String> ans = new ArrayList<>();

       
        for (int i = 0; i < recipes.length; i++) {
            making.put(recipes[i], ingredients.get(i)); 
        }

        boolean progress = true;
        while (progress) { 
            progress = false;
            for (Map.Entry<String, List<String>> entry : making.entrySet()) {
                String recipe = entry.getKey();
                List<String> ingredientList = entry.getValue();
                
                if (pans.contains(recipe)) continue; 

                boolean canMake = true;
                for (String ingredient : ingredientList) {
                    if (!sup.contains(ingredient)) {
                        canMake = false;
                        break;
                    }
                }

                if (canMake) {
                    sup.add(recipe);
                    pans.add(recipe);
                    progress = true;
                }
            }

    
            for (Map.Entry<String, List<String>> entry : making.entrySet()) {
                String recipe = entry.getKey();
                List<String> ingredientList = entry.getValue();
                
                if (pans.contains(recipe)) continue; 

                boolean canMake = true;
                for (String ingredient : ingredientList) {
                    if (!sup.contains(ingredient)) {
                        canMake = false;
                        break;
                    }
                }

                if (canMake) {
                    sup.add(recipe);
                    pans.add(recipe);
                    progress = true;
                }
            }
        }
        ans.addAll(pans);
        return ans;
    }
}
