/*
 * Mobiquity INC
 * This is an Assignment Challenge
 * Written by Nikolaos Bellias
 *
 */
package com.mobiquityinc.packer;

import com.mobiquity.packer.model.TestCase;
import com.mobiquity.packer.model.ThingCombination;
import com.mobiquity.packer.utils.Utils;
import com.mobiquity.packer.view.PackageOptionView;
import com.mobiquityinc.exception.APIException;
import java.io.File;
import java.util.List;

/**
 *
 * @author nikolaos
 */
public class Packer {

    /**
     *
     * @param filePath
     * @return
     * @throws APIException
     */
    public static String pack(String filePath) throws APIException {
        String ans = "";
        File file = new File(filePath);
        if (!file.isFile()) {
            throw new APIException(filePath);
        } else {
            // Read and process cases file
            List<TestCase> caseList = Utils.processPackageFile(filePath);
            // Create package cases for viewing
            List<ThingCombination> myPackage = PackageOptionView.createPackageCases(caseList);
            // Prepare printing
            for (ThingCombination thingCombination : myPackage) {
                if (thingCombination.getItemIndexes() != "") {
                    ans += thingCombination.getItemIndexes() + "\n";
                } else {
                    ans += "-\n";
                }
            }
        }
        return ans;
    }

}
