package com.example.ui.components;

import android.content.SharedPreferences;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AccountBalanceKt;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.ErrorOutlineKt;
import androidx.compose.material.icons.filled.HandshakeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.example.data.model.FinancialItem;
import com.example.data.model.ItemCategory;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FinancialAssetForm.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\u0006\n\u0002\b\t\u001a_\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\u0018\u0010'\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u00120\u00120\nX\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010*\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\f\u0010+\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010,\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\u0018\u0010-\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u00120\u00120\nX\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\f\u00100\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u00101\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\u0018\u00102\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u00120\u00120\nX\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\f\u00105\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u00106\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\u0018\u00107\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u00120\u00120\nX\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\f\u0010:\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010;\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\f\u0010>\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010?\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\n\u0010@\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\f\u0010A\u001a\u0004\u0018\u00010\u0002X\u008a\u008e\u0002²\u0006\n\u0010B\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u0010C\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010E\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010F\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010G\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010J\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010K\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u00020NX\u008a\u008e\u0002²\u0006\n\u0010O\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\f\u0010P\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010Q\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010R\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010S\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010T\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010U\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\f\u0010U\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002²\u0006\n\u0010V\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010W\u001a\u00020\u001dX\u008a\u008e\u0002"}, d2 = {"GLOBAL_STOCK_LIST", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lcom/example/ui/components/StockQuote;", "getGLOBAL_STOCK_LIST", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "FinancialAssetForm", "", "itemToEdit", "Lcom/example/data/model/FinancialItem;", "existingAssetAccounts", "", "onSave", "Lkotlin/Function1;", "onCancel", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "submitButtonText", "", "(Lcom/example/data/model/FinancialItem;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app", "title", "institution", "accountNumber", "owner", "category", "currentValueStr", "investedValueStr", "isLiability", "", "notes", "sourceAccountTitle", "shouldDeductOrAddOpposite", "ownerDropdownExpanded", "categoryDropdownExpanded", "sourceAccountDropdownExpanded", "titleDropdownExpanded", "instDropdownExpanded", "accNoDropdownExpanded", "titlesList", "kotlin.jvm.PlatformType", "showManageTitlesDialog", "titleInputName", "editingTitleName", "titleToDelete", "institutionsList", "showManageInstitutionsDialog", "institutionInputName", "editingInstitutionName", "institutionToDelete", "accountNumbersList", "showManageAccountNumbersDialog", "accountNumberInputName", "editingAccountNumberName", "accountNumberToDelete", "ownersList", "showManageOwnersDialog", "ownerInputName", "editingOwnerName", "ownerToDelete", "categoriesList", "showManageCategoriesDialog", "editingCategoryName", "categoryToDelete", "showAddStockDialog", "stockToEdit", "showDeleteStockDialog", "customSymbol", "customName", "customExchange", "customPriceStr", "selectedStockSymbol", "selectedStockName", "exchangeName", "sharesQuantityStr", "marketPricePerShareStr", "buyPricePerShareStr", "stockQuoteChangePercent", "", "isQuotePositive", "stockQuantityError", "stockPriceError", "titleError", "currentValueError", "investedValueError", "dialogError", "catInputName", "catTypeIsLiability"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FinancialAssetFormKt {
    private static final SnapshotStateList<StockQuote> GLOBAL_STOCK_LIST = SnapshotStateKt.mutableStateListOf();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$685(FinancialItem financialItem, List list, Function1 function1, Function0 function0, Modifier modifier, String str, int i, int i2, Composer composer, int i3) {
        FinancialAssetForm(financialItem, list, function1, function0, modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final SnapshotStateList<StockQuote> getGLOBAL_STOCK_LIST() {
        return GLOBAL_STOCK_LIST;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02dc, code lost:
    
        if (r6 == null) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x034e, code lost:
    
        if (r4 == null) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x161e, code lost:
    
        if (r4 == null) goto L563;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x1699, code lost:
    
        if (r4 == null) goto L574;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1017:0x3141  */
    /* JADX WARN: Removed duplicated region for block: B:1018:0x2f78  */
    /* JADX WARN: Removed duplicated region for block: B:1019:0x2f00  */
    /* JADX WARN: Removed duplicated region for block: B:1024:0x2eab  */
    /* JADX WARN: Removed duplicated region for block: B:1029:0x314b  */
    /* JADX WARN: Removed duplicated region for block: B:1030:0x2c90  */
    /* JADX WARN: Removed duplicated region for block: B:1031:0x2b5d  */
    /* JADX WARN: Removed duplicated region for block: B:1032:0x2acf  */
    /* JADX WARN: Removed duplicated region for block: B:1033:0x29f8  */
    /* JADX WARN: Removed duplicated region for block: B:1036:0x2992  */
    /* JADX WARN: Removed duplicated region for block: B:1039:0x2965  */
    /* JADX WARN: Removed duplicated region for block: B:1046:0x2903 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1047:0x28ba  */
    /* JADX WARN: Removed duplicated region for block: B:1049:0x27dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1050:0x2794  */
    /* JADX WARN: Removed duplicated region for block: B:1051:0x26e1  */
    /* JADX WARN: Removed duplicated region for block: B:1055:0x26a1  */
    /* JADX WARN: Removed duplicated region for block: B:1060:0x268d  */
    /* JADX WARN: Removed duplicated region for block: B:1068:0x25ac  */
    /* JADX WARN: Removed duplicated region for block: B:1069:0x2523  */
    /* JADX WARN: Removed duplicated region for block: B:1070:0x2464  */
    /* JADX WARN: Removed duplicated region for block: B:1072:0x2382 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1073:0x2339  */
    /* JADX WARN: Removed duplicated region for block: B:1075:0x2259 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1076:0x2210  */
    /* JADX WARN: Removed duplicated region for block: B:1077:0x2128  */
    /* JADX WARN: Removed duplicated region for block: B:1078:0x2087  */
    /* JADX WARN: Removed duplicated region for block: B:1079:0x1fe6  */
    /* JADX WARN: Removed duplicated region for block: B:1081:0x1f31  */
    /* JADX WARN: Removed duplicated region for block: B:1082:0x1e8c  */
    /* JADX WARN: Removed duplicated region for block: B:1083:0x1de9  */
    /* JADX WARN: Removed duplicated region for block: B:1086:0x1d13 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1087:0x1cca  */
    /* JADX WARN: Removed duplicated region for block: B:1090:0x1b20  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x1b0e  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x1b1a  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x1cb8  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x1cc4  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x1cfd  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x1d6a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:464:0x1dd7  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x1e7e  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x1f1f  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x1f6d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:477:0x1fd8  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x2079  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x211a  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x21fe  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x220a  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x2243  */
    /* JADX WARN: Removed duplicated region for block: B:497:0x2327  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x2333  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x236c  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x2456  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x2511  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x259e  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x261f  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x268a  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x269e  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x26c2  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x2782  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x278e  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x27c7  */
    /* JADX WARN: Removed duplicated region for block: B:552:0x28a8  */
    /* JADX WARN: Removed duplicated region for block: B:555:0x28b4  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x28ed  */
    /* JADX WARN: Removed duplicated region for block: B:563:0x2958  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x2986  */
    /* JADX WARN: Removed duplicated region for block: B:570:0x29ec  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x2abd  */
    /* JADX WARN: Removed duplicated region for block: B:577:0x2b4f  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x2c82  */
    /* JADX WARN: Removed duplicated region for block: B:583:0x2cf3  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x2e9d  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x2ee0  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x2f72  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x2fcd  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x31e6  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x31f2  */
    /* JADX WARN: Removed duplicated region for block: B:628:0x322b  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x3311  */
    /* JADX WARN: Removed duplicated region for block: B:636:0x331d  */
    /* JADX WARN: Removed duplicated region for block: B:639:0x3356  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x33c2  */
    /* JADX WARN: Removed duplicated region for block: B:647:0x3463  */
    /* JADX WARN: Removed duplicated region for block: B:650:0x34f4  */
    /* JADX WARN: Removed duplicated region for block: B:653:0x34ff  */
    /* JADX WARN: Removed duplicated region for block: B:656:0x355f  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x360a  */
    /* JADX WARN: Removed duplicated region for block: B:662:0x36f6  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x3702  */
    /* JADX WARN: Removed duplicated region for block: B:668:0x373b  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x3821  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x382d  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x3866  */
    /* JADX WARN: Removed duplicated region for block: B:684:0x3950  */
    /* JADX WARN: Removed duplicated region for block: B:687:0x3a14  */
    /* JADX WARN: Removed duplicated region for block: B:690:0x3aa8  */
    /* JADX WARN: Removed duplicated region for block: B:693:0x3b8d  */
    /* JADX WARN: Removed duplicated region for block: B:696:0x3b99  */
    /* JADX WARN: Removed duplicated region for block: B:699:0x3bd2  */
    /* JADX WARN: Removed duplicated region for block: B:704:0x3cb6  */
    /* JADX WARN: Removed duplicated region for block: B:707:0x3cc2  */
    /* JADX WARN: Removed duplicated region for block: B:710:0x3cfb  */
    /* JADX WARN: Removed duplicated region for block: B:715:0x3d67  */
    /* JADX WARN: Removed duplicated region for block: B:718:0x3df9  */
    /* JADX WARN: Removed duplicated region for block: B:721:0x3eaf  */
    /* JADX WARN: Removed duplicated region for block: B:724:0x3f54  */
    /* JADX WARN: Removed duplicated region for block: B:727:0x403d  */
    /* JADX WARN: Removed duplicated region for block: B:730:0x4049  */
    /* JADX WARN: Removed duplicated region for block: B:733:0x4082  */
    /* JADX WARN: Removed duplicated region for block: B:738:0x4168  */
    /* JADX WARN: Removed duplicated region for block: B:741:0x4174  */
    /* JADX WARN: Removed duplicated region for block: B:744:0x41ad  */
    /* JADX WARN: Removed duplicated region for block: B:749:0x4218  */
    /* JADX WARN: Removed duplicated region for block: B:752:0x42a0  */
    /* JADX WARN: Removed duplicated region for block: B:755:0x4355  */
    /* JADX WARN: Removed duplicated region for block: B:758:0x43f3  */
    /* JADX WARN: Removed duplicated region for block: B:761:0x446c  */
    /* JADX WARN: Removed duplicated region for block: B:764:0x479a  */
    /* JADX WARN: Removed duplicated region for block: B:767:0x4884  */
    /* JADX WARN: Removed duplicated region for block: B:770:0x4890  */
    /* JADX WARN: Removed duplicated region for block: B:773:0x48c3  */
    /* JADX WARN: Removed duplicated region for block: B:778:0x49b3  */
    /* JADX WARN: Removed duplicated region for block: B:781:0x49be  */
    /* JADX WARN: Removed duplicated region for block: B:784:0x49d0  */
    /* JADX WARN: Removed duplicated region for block: B:789:0x4b2d  */
    /* JADX WARN: Removed duplicated region for block: B:798:0x4c8c  */
    /* JADX WARN: Removed duplicated region for block: B:807:0x4dac  */
    /* JADX WARN: Removed duplicated region for block: B:813:0x4e75  */
    /* JADX WARN: Removed duplicated region for block: B:828:0x4ff1  */
    /* JADX WARN: Removed duplicated region for block: B:834:0x50ba  */
    /* JADX WARN: Removed duplicated region for block: B:840:0x5178  */
    /* JADX WARN: Removed duplicated region for block: B:846:0x5242  */
    /* JADX WARN: Removed duplicated region for block: B:852:0x5306  */
    /* JADX WARN: Removed duplicated region for block: B:858:0x53d0  */
    /* JADX WARN: Removed duplicated region for block: B:864:0x5497  */
    /* JADX WARN: Removed duplicated region for block: B:870:0x5568  */
    /* JADX WARN: Removed duplicated region for block: B:876:0x5639  */
    /* JADX WARN: Removed duplicated region for block: B:882:0x56fa  */
    /* JADX WARN: Removed duplicated region for block: B:885:0x56eb  */
    /* JADX WARN: Removed duplicated region for block: B:887:0x5624  */
    /* JADX WARN: Removed duplicated region for block: B:889:0x5559  */
    /* JADX WARN: Removed duplicated region for block: B:891:0x5480  */
    /* JADX WARN: Removed duplicated region for block: B:893:0x53c1  */
    /* JADX WARN: Removed duplicated region for block: B:895:0x52f1  */
    /* JADX WARN: Removed duplicated region for block: B:897:0x5233  */
    /* JADX WARN: Removed duplicated region for block: B:899:0x5167  */
    /* JADX WARN: Removed duplicated region for block: B:901:0x50a9  */
    /* JADX WARN: Removed duplicated region for block: B:905:0x4fdc  */
    /* JADX WARN: Removed duplicated region for block: B:907:0x4e62  */
    /* JADX WARN: Removed duplicated region for block: B:910:0x4d91  */
    /* JADX WARN: Removed duplicated region for block: B:913:0x4c58  */
    /* JADX WARN: Removed duplicated region for block: B:915:0x49c0  */
    /* JADX WARN: Removed duplicated region for block: B:916:0x49b5  */
    /* JADX WARN: Removed duplicated region for block: B:918:0x48d9  */
    /* JADX WARN: Removed duplicated region for block: B:919:0x4894  */
    /* JADX WARN: Removed duplicated region for block: B:920:0x47ad  */
    /* JADX WARN: Removed duplicated region for block: B:921:0x4523  */
    /* JADX WARN: Removed duplicated region for block: B:950:0x4401  */
    /* JADX WARN: Removed duplicated region for block: B:951:0x4367  */
    /* JADX WARN: Removed duplicated region for block: B:952:0x42b2  */
    /* JADX WARN: Removed duplicated region for block: B:953:0x421b  */
    /* JADX WARN: Removed duplicated region for block: B:955:0x41c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:956:0x417a  */
    /* JADX WARN: Removed duplicated region for block: B:958:0x4098 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:959:0x404f  */
    /* JADX WARN: Removed duplicated region for block: B:960:0x3f62  */
    /* JADX WARN: Removed duplicated region for block: B:961:0x3ec1  */
    /* JADX WARN: Removed duplicated region for block: B:962:0x3e0b  */
    /* JADX WARN: Removed duplicated region for block: B:963:0x3d6c  */
    /* JADX WARN: Removed duplicated region for block: B:967:0x3d11 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:968:0x3cc8  */
    /* JADX WARN: Removed duplicated region for block: B:970:0x3be8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:971:0x3b9f  */
    /* JADX WARN: Removed duplicated region for block: B:972:0x3ab6  */
    /* JADX WARN: Removed duplicated region for block: B:973:0x3a26  */
    /* JADX WARN: Removed duplicated region for block: B:974:0x3962  */
    /* JADX WARN: Removed duplicated region for block: B:976:0x387c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:977:0x3833  */
    /* JADX WARN: Removed duplicated region for block: B:979:0x3751 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:980:0x3708  */
    /* JADX WARN: Removed duplicated region for block: B:981:0x3618  */
    /* JADX WARN: Removed duplicated region for block: B:982:0x3577  */
    /* JADX WARN: Removed duplicated region for block: B:983:0x350e  */
    /* JADX WARN: Removed duplicated region for block: B:984:0x34f7  */
    /* JADX WARN: Removed duplicated region for block: B:985:0x3475  */
    /* JADX WARN: Removed duplicated region for block: B:986:0x33c9  */
    /* JADX WARN: Removed duplicated region for block: B:993:0x336c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:994:0x3323  */
    /* JADX WARN: Removed duplicated region for block: B:996:0x3241 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:997:0x31f8  */
    /* JADX WARN: Type inference failed for: r11v59, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v201 */
    /* JADX WARN: Type inference failed for: r12v202, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v207, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v323, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v325, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v346, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v348, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v366, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v368, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v417 */
    /* JADX WARN: Type inference failed for: r13v221, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v223, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v224, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v228, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v231, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v232, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v233, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v265, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v267, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r149v19 */
    /* JADX WARN: Type inference failed for: r149v20, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r149v21 */
    /* JADX WARN: Type inference failed for: r149v22, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r149v23 */
    /* JADX WARN: Type inference failed for: r149v24 */
    /* JADX WARN: Type inference failed for: r14v140, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v142, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v143, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v144, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v149, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v150, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v151, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v152, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v153, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v154, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v155, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v156, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v175, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v185, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r216v14 */
    /* JADX WARN: Type inference failed for: r216v4 */
    /* JADX WARN: Type inference failed for: r216v5, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r4v420, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r51v0 */
    /* JADX WARN: Type inference failed for: r51v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r51v24 */
    /* JADX WARN: Type inference failed for: r6v285, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v289, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v291, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v295, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v359, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v285, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v287, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v290, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v296, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v111, types: [androidx.compose.runtime.SnapshotMutationPolicy, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FinancialAssetForm(com.example.data.model.FinancialItem r304, java.util.List<com.example.data.model.FinancialItem> r305, final kotlin.jvm.functions.Function1<? super com.example.data.model.FinancialItem, kotlin.Unit> r306, final kotlin.jvm.functions.Function0<kotlin.Unit> r307, androidx.compose.ui.Modifier r308, java.lang.String r309, androidx.compose.runtime.Composer r310, final int r311, final int r312) {
        /*
            Method dump skipped, instructions count: 22300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm(com.example.data.model.FinancialItem, java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String FinancialAssetForm$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$17(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$21(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean FinancialAssetForm$lambda$24(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$25(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String FinancialAssetForm$lambda$27(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$30(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean FinancialAssetForm$lambda$33(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$34(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean FinancialAssetForm$lambda$36(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$37(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean FinancialAssetForm$lambda$39(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$40(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean FinancialAssetForm$lambda$42(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$43(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean FinancialAssetForm$lambda$45(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$46(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean FinancialAssetForm$lambda$48(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$49(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean FinancialAssetForm$lambda$51(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$52(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final List<String> FinancialAssetForm$lambda$62(MutableState<List<String>> mutableState) {
        return mutableState.getValue();
    }

    private static final void FinancialAssetForm$saveTitlesToPrefs(SharedPreferences titlePrefs, MutableState<List<String>> mutableState, List<String> list) {
        mutableState.setValue(list);
        titlePrefs.edit().putStringSet("custom_titles_v1", CollectionsKt.toSet(list)).apply();
    }

    private static final boolean FinancialAssetForm$lambda$65(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$66(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String FinancialAssetForm$lambda$68(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$71(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$74(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<String> FinancialAssetForm$lambda$80(MutableState<List<String>> mutableState) {
        return mutableState.getValue();
    }

    private static final void FinancialAssetForm$saveInstitutionsToPrefs(SharedPreferences instPrefs, MutableState<List<String>> mutableState, List<String> list) {
        mutableState.setValue(list);
        instPrefs.edit().putStringSet("custom_institutions_v1", CollectionsKt.toSet(list)).apply();
    }

    private static final boolean FinancialAssetForm$lambda$83(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$84(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String FinancialAssetForm$lambda$86(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$89(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$92(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<String> FinancialAssetForm$lambda$98(MutableState<List<String>> mutableState) {
        return mutableState.getValue();
    }

    private static final void FinancialAssetForm$saveAccountNumbersToPrefs(SharedPreferences accNoPrefs, MutableState<List<String>> mutableState, List<String> list) {
        mutableState.setValue(list);
        accNoPrefs.edit().putStringSet("custom_account_nos_v1", CollectionsKt.toSet(list)).apply();
    }

    private static final boolean FinancialAssetForm$lambda$101(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$102(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String FinancialAssetForm$lambda$104(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$107(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$110(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<String> FinancialAssetForm$lambda$114(MutableState<List<String>> mutableState) {
        return mutableState.getValue();
    }

    private static final void FinancialAssetForm$saveOwnersToPrefs(SharedPreferences ownerPrefs, MutableState<List<String>> mutableState, List<String> list) {
        mutableState.setValue(list);
        ownerPrefs.edit().putStringSet("custom_owners_v1", CollectionsKt.toSet(list)).apply();
    }

    private static final boolean FinancialAssetForm$lambda$117(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$118(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String FinancialAssetForm$lambda$120(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$123(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$126(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<String> FinancialAssetForm$lambda$130(MutableState<List<String>> mutableState) {
        return mutableState.getValue();
    }

    private static final void FinancialAssetForm$saveCategoriesToPrefs(SharedPreferences prefs, MutableState<List<String>> mutableState, List<String> list) {
        mutableState.setValue(list);
        prefs.edit().putStringSet("custom_categories_v2", CollectionsKt.toSet(list)).apply();
    }

    private static final boolean FinancialAssetForm$lambda$133(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$134(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String FinancialAssetForm$lambda$136(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$139(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean FinancialAssetForm$lambda$142(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$143(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final StockQuote FinancialAssetForm$lambda$145(MutableState<StockQuote> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean FinancialAssetForm$lambda$148(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$149(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String FinancialAssetForm$lambda$151(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$154(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$157(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$160(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String FinancialAssetForm$lambda$163(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$166(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$172(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$176(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$180(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final double FinancialAssetForm$lambda$183(MutableState<Double> mutableState) {
        return mutableState.getValue().doubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FinancialAssetForm$lambda$184(MutableState<Double> mutableState, double d) {
        mutableState.setValue(Double.valueOf(d));
    }

    private static final boolean FinancialAssetForm$lambda$186(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FinancialAssetForm$lambda$187(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String FinancialAssetForm$lambda$190(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$193(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$196(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$199(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$lambda$202(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String FinancialAssetForm$validateAndCleanCurrencyInput(String input) {
        return StringsKt.replace$default(StringsKt.replace$default(input, ServerSentEventKt.SPACE, "", false, 4, (Object) null), ",", "", false, 4, (Object) null);
    }

    private static final boolean FinancialAssetForm$performValidation(boolean isStockCategory, boolean isMFOnly, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<String> mutableState8, MutableState<String> mutableState9, MutableState<String> mutableState10, MutableState<String> mutableState11, MutableState<String> mutableState12, MutableState<String> mutableState13) {
        boolean isValid = true;
        if (StringsKt.trim((CharSequence) FinancialAssetForm$lambda$1(mutableState)).toString().length() == 0) {
            if (isStockCategory) {
                mutableState.setValue(FinancialAssetForm$lambda$163(mutableState2) + " - " + FinancialAssetForm$lambda$166(mutableState3));
                mutableState4.setValue(null);
            } else {
                mutableState4.setValue("Title is required (e.g., Savings Account)");
                isValid = false;
            }
        } else {
            mutableState4.setValue(null);
        }
        if (isStockCategory) {
            String cleanedQty = FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$172(mutableState5));
            Double qty = StringsKt.toDoubleOrNull(cleanedQty);
            if (qty == null || qty.doubleValue() <= 0.0d) {
                mutableState6.setValue("Enter valid share quantity (> 0)");
                isValid = false;
            } else {
                mutableState6.setValue(null);
            }
            String cleanedMktPrice = FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$176(mutableState7));
            Double mktPrice = StringsKt.toDoubleOrNull(cleanedMktPrice);
            if (mktPrice == null || mktPrice.doubleValue() <= 0.0d) {
                mutableState8.setValue("Enter valid share price (> 0)");
                isValid = false;
            } else {
                mutableState8.setValue(null);
            }
            if (isValid && qty != null && mktPrice != null) {
                String cleanedBuyPrice = FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$180(mutableState9));
                Double doubleOrNull = StringsKt.toDoubleOrNull(cleanedBuyPrice);
                double buyPrice = doubleOrNull != null ? doubleOrNull.doubleValue() : mktPrice.doubleValue();
                double totalCurVal = qty.doubleValue() * mktPrice.doubleValue();
                double totalInvVal = qty.doubleValue() * buyPrice;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(totalCurVal)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                mutableState10.setValue(format);
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(totalInvVal)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                mutableState11.setValue(format2);
                return isValid;
            }
            return isValid;
        }
        String cleanedCurVal = FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$17(mutableState10));
        if (!(cleanedCurVal.length() == 0)) {
            Double num = StringsKt.toDoubleOrNull(cleanedCurVal);
            if (num == null || num.doubleValue() < 0.0d) {
                mutableState12.setValue("Enter a valid non-negative number");
                isValid = false;
            } else {
                mutableState12.setValue(null);
            }
        } else {
            mutableState12.setValue("Current amount is required");
            isValid = false;
        }
        if (isMFOnly && !StringsKt.isBlank(FinancialAssetForm$lambda$21(mutableState11))) {
            String cleanedInvVal = FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$21(mutableState11));
            Double num2 = StringsKt.toDoubleOrNull(cleanedInvVal);
            if (num2 == null || num2.doubleValue() < 0.0d) {
                mutableState13.setValue("Enter a valid positive investment amount");
                return false;
            }
            mutableState13.setValue(null);
            return isValid;
        }
        mutableState13.setValue(null);
        return isValid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$217$lambda$216$lambda$205$lambda$204(MutableState $isLiability$delegate, MutableState $category$delegate) {
        FinancialAssetForm$lambda$25($isLiability$delegate, false);
        $category$delegate.setValue(ItemCategory.BANK_ACCOUNT.getDisplayName());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$217$lambda$216$lambda$207$lambda$206(MutableState $isLiability$delegate, MutableState $category$delegate, MutableState $title$delegate) {
        FinancialAssetForm$lambda$25($isLiability$delegate, false);
        $category$delegate.setValue("IPO Application");
        if (StringsKt.isBlank(FinancialAssetForm$lambda$1($title$delegate))) {
            $title$delegate.setValue("IPO Application");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$217$lambda$216$lambda$209$lambda$208(MutableState $isLiability$delegate, MutableState $category$delegate, MutableState $title$delegate, MutableState $institution$delegate) {
        FinancialAssetForm$lambda$25($isLiability$delegate, false);
        $category$delegate.setValue("Paid Loan / Aapel Loan (આપેલ લોન)");
        if (StringsKt.isBlank(FinancialAssetForm$lambda$1($title$delegate))) {
            $title$delegate.setValue("Loan Given to ");
        }
        if (StringsKt.isBlank(FinancialAssetForm$lambda$4($institution$delegate))) {
            $institution$delegate.setValue("Borrower / Friend");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$217$lambda$216$lambda$211$lambda$210(MutableState $isLiability$delegate, MutableState $category$delegate) {
        FinancialAssetForm$lambda$25($isLiability$delegate, true);
        $category$delegate.setValue(ItemCategory.LOAN_LIABILITY.getDisplayName());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$217$lambda$216$lambda$213$lambda$212(MutableState $isLiability$delegate, MutableState $category$delegate, MutableState $title$delegate) {
        FinancialAssetForm$lambda$25($isLiability$delegate, false);
        $category$delegate.setValue("Income / Earnings");
        if (StringsKt.isBlank(FinancialAssetForm$lambda$1($title$delegate))) {
            $title$delegate.setValue("Salary / Income");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$217$lambda$216$lambda$215$lambda$214(MutableState $isLiability$delegate, MutableState $category$delegate, MutableState $title$delegate) {
        FinancialAssetForm$lambda$25($isLiability$delegate, true);
        $category$delegate.setValue(ItemCategory.EXPENSE.getDisplayName());
        if (StringsKt.isBlank(FinancialAssetForm$lambda$1($title$delegate))) {
            $title$delegate.setValue("Expense Outflow");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$240$lambda$220$lambda$219$lambda$218(MutableState $showManageCategoriesDialog$delegate) {
        FinancialAssetForm$lambda$134($showManageCategoriesDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$240$lambda$222$lambda$221(MutableState $categoryDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$40($categoryDropdownExpanded$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$240$lambda$224(androidx.compose.runtime.MutableState r49, androidx.compose.runtime.Composer r50, int r51) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$240$lambda$224(androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$240$lambda$226$lambda$225(MutableState $categoryDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$40($categoryDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$240$lambda$239(final MutableState $categoryDropdownExpanded$delegate, final MutableState $showManageCategoriesDialog$delegate, MutableState $categoriesList$delegate, final MutableState $category$delegate, final MutableState $editingCategoryName$delegate, final MutableState $categoryToDelete$delegate, final MutableState $institution$delegate, final MutableState $title$delegate, final MutableState $isLiability$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation($composer, "C721@32573L138,704@31704L1025,727@32747L19,*731@32889L2726,778@35651L1442,730@32840L4275:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2089665338, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:704)");
            }
            Function2<Composer, Integer, Unit> lambda$1237955318$app = ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1237955318$app();
            ComposerKt.sourceInformationMarkerStart($composer, 1876333232, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda148
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$228$lambda$227(MutableState.this, $showManageCategoriesDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenuItem(lambda$1237955318$app, (Function0) obj, null, null, null, false, null, null, null, $composer, 54, 508);
            DividerKt.m2072HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer, 0, 7);
            Composer composer = $composer;
            for (final String str : FinancialAssetForm$lambda$130($categoriesList$delegate)) {
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(777225798, true, new Function2() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda149
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$238$lambda$235(str, $category$delegate, $categoryDropdownExpanded$delegate, $editingCategoryName$delegate, $showManageCategoriesDialog$delegate, $categoryToDelete$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, -157153768, "CC(remember):FinancialAssetForm.kt#9igjgp");
                boolean changed = composer.changed(str);
                Object rememberedValue2 = $composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    obj2 = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda150
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$238$lambda$237$lambda$236(str, $category$delegate, $institution$delegate, $title$delegate, $isLiability$delegate, $categoryDropdownExpanded$delegate);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    obj2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) obj2, null, null, null, false, null, null, null, composer, 6, 508);
                composer = $composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$228$lambda$227(MutableState $categoryDropdownExpanded$delegate, MutableState $showManageCategoriesDialog$delegate) {
        FinancialAssetForm$lambda$40($categoryDropdownExpanded$delegate, false);
        FinancialAssetForm$lambda$134($showManageCategoriesDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0341  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$238$lambda$235(final java.lang.String r65, androidx.compose.runtime.MutableState r66, androidx.compose.runtime.MutableState r67, final androidx.compose.runtime.MutableState r68, final androidx.compose.runtime.MutableState r69, final androidx.compose.runtime.MutableState r70, androidx.compose.runtime.Composer r71, int r72) {
        /*
            Method dump skipped, instructions count: 1070
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$238$lambda$235(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$238$lambda$235$lambda$234$lambda$233$lambda$230$lambda$229(String $catName, MutableState $categoryDropdownExpanded$delegate, MutableState $editingCategoryName$delegate, MutableState $showManageCategoriesDialog$delegate) {
        FinancialAssetForm$lambda$40($categoryDropdownExpanded$delegate, false);
        $editingCategoryName$delegate.setValue($catName);
        FinancialAssetForm$lambda$134($showManageCategoriesDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$238$lambda$235$lambda$234$lambda$233$lambda$232$lambda$231(String $catName, MutableState $categoryDropdownExpanded$delegate, MutableState $categoryToDelete$delegate) {
        FinancialAssetForm$lambda$40($categoryDropdownExpanded$delegate, false);
        $categoryToDelete$delegate.setValue($catName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$240$lambda$239$lambda$238$lambda$237$lambda$236(String $catName, MutableState $category$delegate, MutableState $institution$delegate, MutableState $title$delegate, MutableState $isLiability$delegate, MutableState $categoryDropdownExpanded$delegate) {
        $category$delegate.setValue($catName);
        if (StringsKt.contains((CharSequence) $catName, (CharSequence) "Share Market", true) || StringsKt.contains((CharSequence) $catName, (CharSequence) "Stocks", true)) {
            if (StringsKt.isBlank(FinancialAssetForm$lambda$4($institution$delegate))) {
                $institution$delegate.setValue("Zerodha / Groww");
            }
            if (StringsKt.isBlank(FinancialAssetForm$lambda$1($title$delegate))) {
                $title$delegate.setValue("RELIANCE - Reliance Industries");
            }
        } else if (StringsKt.contains((CharSequence) $catName, (CharSequence) "Expense", true)) {
            FinancialAssetForm$lambda$25($isLiability$delegate, true);
            if (StringsKt.isBlank(FinancialAssetForm$lambda$1($title$delegate))) {
                $title$delegate.setValue("Expense Outflow");
            }
        } else if (StringsKt.contains((CharSequence) $catName, (CharSequence) "Paid Loan", true) || StringsKt.contains((CharSequence) $catName, (CharSequence) "Aapel", true) || StringsKt.contains((CharSequence) $catName, (CharSequence) "Chekvel", true) || StringsKt.contains((CharSequence) $catName, (CharSequence) "Loan Given", true)) {
            FinancialAssetForm$lambda$25($isLiability$delegate, false);
            if (StringsKt.isBlank(FinancialAssetForm$lambda$1($title$delegate))) {
                $title$delegate.setValue("Loan Given to ");
            }
            if (StringsKt.isBlank(FinancialAssetForm$lambda$4($institution$delegate))) {
                $institution$delegate.setValue("Borrower / Friend");
            }
        } else if (StringsKt.contains((CharSequence) $catName, (CharSequence) "Loan", true) || StringsKt.contains((CharSequence) $catName, (CharSequence) "Due", true)) {
            FinancialAssetForm$lambda$25($isLiability$delegate, true);
        } else {
            FinancialAssetForm$lambda$25($isLiability$delegate, false);
        }
        FinancialAssetForm$lambda$40($categoryDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$243$lambda$242(MutableState $sourceAccountDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$43($sourceAccountDropdownExpanded$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$266$lambda$245(java.lang.String r49, androidx.compose.runtime.MutableState r50, androidx.compose.runtime.Composer r51, int r52) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$266$lambda$245(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$247$lambda$246(MutableState $sourceAccountDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$43($sourceAccountDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$257(List $existingAssetAccounts, final String $defaultAccountText, final MutableState $sourceAccountTitle$delegate, final MutableState $sourceAccountDropdownExpanded$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation($composer, "C875@41516L28,876@41580L145,874@41467L280:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-600527638, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:874)");
            }
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1282739430, true, new Function2() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda126
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$248($defaultAccountText, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer, 54);
            ComposerKt.sourceInformationMarkerStart($composer, -1581437989, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda127
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$250$lambda$249(MutableState.this, $sourceAccountDropdownExpanded$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda, (Function0) obj, null, null, null, false, null, null, null, $composer, 54, 508);
            Collection arrayList = new ArrayList();
            for (Object obj3 : $existingAssetAccounts) {
                if (!((FinancialItem) obj3).isLiability()) {
                    arrayList.add(obj3);
                }
            }
            Iterable<FinancialItem> bankAndCashAccounts = (List) arrayList;
            if (((Collection) bankAndCashAccounts).isEmpty()) {
                $composer.startReplaceGroup(-1821190248);
            } else {
                $composer.startReplaceGroup(-1779594851);
                ComposerKt.sourceInformation($composer, "884@41928L19,*887@42094L401,893@42539L176,886@42037L708");
                DividerKt.m2072HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer, 0, 7);
                for (final FinancialItem financialItem : bankAndCashAccounts) {
                    ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1699923866, true, new Function2() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda128
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj4, Object obj5) {
                            return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$256$lambda$253(FinancialItem.this, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    }, $composer, 54);
                    ComposerKt.sourceInformationMarkerStart($composer, -1781820678, "CC(remember):FinancialAssetForm.kt#9igjgp");
                    boolean changed = $composer.changed(financialItem);
                    Object rememberedValue2 = $composer.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        obj2 = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda129
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$256$lambda$255$lambda$254(FinancialItem.this, $sourceAccountTitle$delegate, $sourceAccountDropdownExpanded$delegate);
                            }
                        };
                        $composer.updateRememberedValue(obj2);
                    } else {
                        obj2 = rememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    AndroidMenu_androidKt.DropdownMenuItem(rememberComposableLambda2, (Function0) obj2, null, null, null, false, null, null, null, $composer, 6, 508);
                }
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$248(String $defaultAccountText, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C875@41518L24:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1282739430, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:875)");
            }
            TextKt.m2693Text4IGK_g($defaultAccountText, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$250$lambda$249(MutableState $sourceAccountTitle$delegate, MutableState $sourceAccountDropdownExpanded$delegate) {
        $sourceAccountTitle$delegate.setValue("");
        FinancialAssetForm$lambda$43($sourceAccountDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$256$lambda$253(com.example.data.model.FinancialItem r51, androidx.compose.runtime.Composer r52, int r53) {
        /*
            Method dump skipped, instructions count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$256$lambda$253(com.example.data.model.FinancialItem, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$257$lambda$256$lambda$255$lambda$254(FinancialItem $acc, MutableState $sourceAccountTitle$delegate, MutableState $sourceAccountDropdownExpanded$delegate) {
        $sourceAccountTitle$delegate.setValue($acc.getTitle());
        FinancialAssetForm$lambda$43($sourceAccountDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$259$lambda$258(MutableState $sourceAccountTitle$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $sourceAccountTitle$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$260(boolean $isIncome, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C907@43150L70:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2096181599, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:907)");
            }
            TextKt.m2693Text4IGK_g($isIncome ? "Deposit Account Name" : "Paid By Account Name", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$262$lambda$261(MutableState $shouldDeductOrAddOpposite$delegate) {
        FinancialAssetForm$lambda$34($shouldDeductOrAddOpposite$delegate, !FinancialAssetForm$lambda$33($shouldDeductOrAddOpposite$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$266$lambda$265$lambda$264$lambda$263(MutableState $shouldDeductOrAddOpposite$delegate, boolean it) {
        FinancialAssetForm$lambda$34($shouldDeductOrAddOpposite$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$269$lambda$268$lambda$267(MutableState $showManageTitlesDialog$delegate) {
        FinancialAssetForm$lambda$66($showManageTitlesDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$273$lambda$272(MutableState $title$delegate, MutableState $titleError$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $title$delegate.setValue(it);
        if (FinancialAssetForm$lambda$196($titleError$delegate) != null && !StringsKt.isBlank(it)) {
            $titleError$delegate.setValue(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$274(boolean $isPaidLoanCategory, boolean $isStockCategory, boolean $isIncomeCategory, boolean $isExpenseCategory, Composer $composer, int $changed) {
        String str;
        ComposerKt.sourceInformation($composer, "C993@48029L493:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(313219035, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:993)");
            }
            if ($isPaidLoanCategory) {
                str = "e.g. Ramesh Bhai, Amit Patel, Mitra";
            } else if ($isStockCategory) {
                str = "e.g. RELIANCE - Reliance Industries";
            } else if ($isIncomeCategory) {
                str = "e.g. Salary, Client Payment, Dividend";
            } else {
                str = $isExpenseCategory ? "e.g. House Rent, Grocery, Medical" : "e.g. HDFC Salary Account";
            }
            TextKt.m2693Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$277(final MutableState $titleDropdownExpanded$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1005@48641L50,1004@48595L421:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(209922841, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1004)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -127610485, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda143
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$293$lambda$277$lambda$276$lambda$275(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "title_dropdown_toggle"), false, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.m6986getLambda$2132601828$app(), $composer, 196662, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$277$lambda$276$lambda$275(MutableState $titleDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$46($titleDropdownExpanded$delegate, !FinancialAssetForm$lambda$45($titleDropdownExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$271$lambda$270(String $err, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1016@49201L11,1016@49162L57:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2025481598, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1016)");
            }
            TextKt.m2693Text4IGK_g($err, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$279$lambda$278(MutableState $titleDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$46($titleDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$292(MutableState $titleDropdownExpanded$delegate, final MutableState $showManageTitlesDialog$delegate, MutableState $titlesList$delegate, final MutableState $title$delegate, final MutableState $editingTitleName$delegate, final MutableState $titleInputName$delegate, final MutableState $titleToDelete$delegate, final MutableState $titleError$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        ComposableLambda composableLambda;
        final MutableState mutableState = $titleDropdownExpanded$delegate;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation($composer, "C1045@50454L131,1028@49589L1014,1051@50621L19,*1055@50757L2755,1103@53548L197,1054@50708L3059:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1165010119, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1028)");
            }
            Function2<Composer, Integer, Unit> lambda$197663479$app = ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$197663479$app();
            ComposerKt.sourceInformationMarkerStart($composer, -1411711510, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda151
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$281$lambda$280(MutableState.this, $showManageTitlesDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            String str = "CC(remember):FinancialAssetForm.kt#9igjgp";
            AndroidMenu_androidKt.DropdownMenuItem(lambda$197663479$app, (Function0) obj, null, null, null, false, null, null, null, $composer, 54, 508);
            Composer composer = $composer;
            DividerKt.m2072HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            for (final String str2 : FinancialAssetForm$lambda$62($titlesList$delegate)) {
                String str3 = str;
                final MutableState mutableState2 = mutableState;
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-263066041, true, new Function2() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda153
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$291$lambda$288(str2, $title$delegate, mutableState, $editingTitleName$delegate, $titleInputName$delegate, $showManageTitlesDialog$delegate, $titleToDelete$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, 849768540, str3);
                boolean changed = composer.changed(str2);
                Object rememberedValue2 = $composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    composableLambda = rememberComposableLambda;
                    obj2 = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda154
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$291$lambda$290$lambda$289(str2, $title$delegate, $titleError$delegate, mutableState2);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    composableLambda = rememberComposableLambda;
                    obj2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) obj2, null, null, null, false, null, null, null, $composer, 6, 508);
                mutableState = $titleDropdownExpanded$delegate;
                composer = $composer;
                str = str3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$281$lambda$280(MutableState $titleDropdownExpanded$delegate, MutableState $showManageTitlesDialog$delegate) {
        FinancialAssetForm$lambda$46($titleDropdownExpanded$delegate, false);
        FinancialAssetForm$lambda$66($showManageTitlesDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0431  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$291$lambda$288(final java.lang.String r67, androidx.compose.runtime.MutableState r68, final androidx.compose.runtime.MutableState r69, final androidx.compose.runtime.MutableState r70, final androidx.compose.runtime.MutableState r71, final androidx.compose.runtime.MutableState r72, final androidx.compose.runtime.MutableState r73, androidx.compose.runtime.Composer r74, int r75) {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$291$lambda$288(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$291$lambda$288$lambda$287$lambda$286$lambda$283$lambda$282(String $tName, MutableState $titleDropdownExpanded$delegate, MutableState $editingTitleName$delegate, MutableState $titleInputName$delegate, MutableState $showManageTitlesDialog$delegate) {
        FinancialAssetForm$lambda$46($titleDropdownExpanded$delegate, false);
        $editingTitleName$delegate.setValue($tName);
        Intrinsics.checkNotNull($tName);
        $titleInputName$delegate.setValue($tName);
        FinancialAssetForm$lambda$66($showManageTitlesDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$291$lambda$288$lambda$287$lambda$286$lambda$285$lambda$284(String $tName, MutableState $titleDropdownExpanded$delegate, MutableState $titleToDelete$delegate) {
        FinancialAssetForm$lambda$46($titleDropdownExpanded$delegate, false);
        $titleToDelete$delegate.setValue($tName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$293$lambda$292$lambda$291$lambda$290$lambda$289(String $tName, MutableState $title$delegate, MutableState $titleError$delegate, MutableState $titleDropdownExpanded$delegate) {
        Intrinsics.checkNotNull($tName);
        $title$delegate.setValue($tName);
        if (FinancialAssetForm$lambda$196($titleError$delegate) != null) {
            $titleError$delegate.setValue(null);
        }
        FinancialAssetForm$lambda$46($titleDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$316$lambda$296$lambda$295$lambda$294(MutableState $showManageOwnersDialog$delegate) {
        FinancialAssetForm$lambda$118($showManageOwnersDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$316$lambda$298$lambda$297(MutableState $ownerDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$37($ownerDropdownExpanded$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$316$lambda$300(androidx.compose.runtime.MutableState r49, androidx.compose.runtime.Composer r50, int r51) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$316$lambda$300(androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$316$lambda$302$lambda$301(MutableState $ownerDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$37($ownerDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$316$lambda$315(MutableState $ownerDropdownExpanded$delegate, final MutableState $showManageOwnersDialog$delegate, MutableState $ownersList$delegate, final MutableState $owner$delegate, final MutableState $editingOwnerName$delegate, final MutableState $ownerInputName$delegate, final MutableState $ownerToDelete$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        ComposableLambda composableLambda;
        final MutableState mutableState = $ownerDropdownExpanded$delegate;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation($composer, "C1182@56930L131,1165@56065L1014,1188@57097L19,*1192@57237L2779,1240@60052L131,1191@57188L3017:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(124718280, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1165)");
            }
            Function2<Composer, Integer, Unit> m7008getLambda$842628360$app = ComposableSingletons$FinancialAssetFormKt.INSTANCE.m7008getLambda$842628360$app();
            ComposerKt.sourceInformationMarkerStart($composer, -404788821, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda156
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$304$lambda$303(MutableState.this, $showManageOwnersDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            String str = "CC(remember):FinancialAssetForm.kt#9igjgp";
            AndroidMenu_androidKt.DropdownMenuItem(m7008getLambda$842628360$app, (Function0) obj, null, null, null, false, null, null, null, $composer, 54, 508);
            Composer composer = $composer;
            DividerKt.m2072HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            for (final String str2 : FinancialAssetForm$lambda$114($ownersList$delegate)) {
                String str3 = str;
                final MutableState mutableState2 = mutableState;
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1303357880, true, new Function2() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda157
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$314$lambda$311(str2, $owner$delegate, mutableState, $editingOwnerName$delegate, $ownerInputName$delegate, $showManageOwnersDialog$delegate, $ownerToDelete$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, 1856692059, str3);
                boolean changed = composer.changed(str2);
                Object rememberedValue2 = $composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    composableLambda = rememberComposableLambda;
                    obj2 = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda158
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$314$lambda$313$lambda$312(str2, $owner$delegate, mutableState2);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    composableLambda = rememberComposableLambda;
                    obj2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) obj2, null, null, null, false, null, null, null, $composer, 6, 508);
                mutableState = $ownerDropdownExpanded$delegate;
                composer = $composer;
                str = str3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$304$lambda$303(MutableState $ownerDropdownExpanded$delegate, MutableState $showManageOwnersDialog$delegate) {
        FinancialAssetForm$lambda$37($ownerDropdownExpanded$delegate, false);
        FinancialAssetForm$lambda$118($showManageOwnersDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0431  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$314$lambda$311(final java.lang.String r67, androidx.compose.runtime.MutableState r68, final androidx.compose.runtime.MutableState r69, final androidx.compose.runtime.MutableState r70, final androidx.compose.runtime.MutableState r71, final androidx.compose.runtime.MutableState r72, final androidx.compose.runtime.MutableState r73, androidx.compose.runtime.Composer r74, int r75) {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$314$lambda$311(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$314$lambda$311$lambda$310$lambda$309$lambda$306$lambda$305(String $ownerName, MutableState $ownerDropdownExpanded$delegate, MutableState $editingOwnerName$delegate, MutableState $ownerInputName$delegate, MutableState $showManageOwnersDialog$delegate) {
        FinancialAssetForm$lambda$37($ownerDropdownExpanded$delegate, false);
        $editingOwnerName$delegate.setValue($ownerName);
        Intrinsics.checkNotNull($ownerName);
        $ownerInputName$delegate.setValue($ownerName);
        FinancialAssetForm$lambda$118($showManageOwnersDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$314$lambda$311$lambda$310$lambda$309$lambda$308$lambda$307(String $ownerName, MutableState $ownerDropdownExpanded$delegate, MutableState $ownerToDelete$delegate) {
        FinancialAssetForm$lambda$37($ownerDropdownExpanded$delegate, false);
        $ownerToDelete$delegate.setValue($ownerName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$316$lambda$315$lambda$314$lambda$313$lambda$312(String $ownerName, MutableState $owner$delegate, MutableState $ownerDropdownExpanded$delegate) {
        Intrinsics.checkNotNull($ownerName);
        $owner$delegate.setValue($ownerName);
        FinancialAssetForm$lambda$37($ownerDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$319$lambda$318$lambda$317(MutableState $showManageInstitutionsDialog$delegate) {
        FinancialAssetForm$lambda$84($showManageInstitutionsDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$321$lambda$320(MutableState $institution$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $institution$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$322(boolean $isPaidLoanCategory, boolean $isStockCategory, Composer $composer, int $changed) {
        String str;
        ComposerKt.sourceInformation($composer, "C1280@61696L319:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1767364643, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1280)");
            }
            if ($isPaidLoanCategory) {
                str = "e.g. +91 9876543210 / Friend / Business";
            } else {
                str = $isStockCategory ? "e.g. Zerodha, Groww, Angel One" : "e.g. State Bank of India";
            }
            TextKt.m2693Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$323(boolean $isPaidLoanCategory, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1289@62087L198:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(328470908, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1289)");
            }
            Icons.Filled filled = Icons.INSTANCE.getDefault();
            IconKt.m2150Iconww6aTOc($isPaidLoanCategory ? HandshakeKt.getHandshake(filled) : AccountBalanceKt.getAccountBalance(filled), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$326(final MutableState $instDropdownExpanded$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1296@62404L48,1295@62358L431:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1870660837, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1295)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1886234891, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda162
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$342$lambda$326$lambda$325$lambda$324(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "institution_dropdown_toggle"), false, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$81781790$app(), $composer, 196662, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$326$lambda$325$lambda$324(MutableState $instDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$49($instDropdownExpanded$delegate, !FinancialAssetForm$lambda$48($instDropdownExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$328$lambda$327(MutableState $instDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$49($instDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$341(MutableState $instDropdownExpanded$delegate, final MutableState $showManageInstitutionsDialog$delegate, MutableState $institutionsList$delegate, final MutableState $institution$delegate, final MutableState $editingInstitutionName$delegate, final MutableState $institutionInputName$delegate, final MutableState $institutionToDelete$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        ComposableLambda composableLambda;
        final MutableState mutableState = $instDropdownExpanded$delegate;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation($composer, "C1332@64027L136,1315@63156L1025,1338@64199L19,*1342@64344L2819,1390@67199L135,1341@64295L3061:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-915573559, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1315)");
            }
            Function2<Composer, Integer, Unit> m6979getLambda$1882920199$app = ComposableSingletons$FinancialAssetFormKt.INSTANCE.m6979getLambda$1882920199$app();
            ComposerKt.sourceInformationMarkerStart($composer, 602134065, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda109
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$330$lambda$329(MutableState.this, $showManageInstitutionsDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            String str = "CC(remember):FinancialAssetForm.kt#9igjgp";
            AndroidMenu_androidKt.DropdownMenuItem(m6979getLambda$1882920199$app, (Function0) obj, null, null, null, false, null, null, null, $composer, 54, 508);
            Composer composer = $composer;
            DividerKt.m2072HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            for (final String str2 : FinancialAssetForm$lambda$80($institutionsList$delegate)) {
                String str3 = str;
                final MutableState mutableState2 = mutableState;
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1951317577, true, new Function2() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda112
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$340$lambda$337(str2, $institution$delegate, mutableState, $editingInstitutionName$delegate, $institutionInputName$delegate, $showManageInstitutionsDialog$delegate, $institutionToDelete$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, -1431351296, str3);
                boolean changed = composer.changed(str2);
                Object rememberedValue2 = $composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    composableLambda = rememberComposableLambda;
                    obj2 = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda113
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$340$lambda$339$lambda$338(str2, $institution$delegate, mutableState2);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    composableLambda = rememberComposableLambda;
                    obj2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) obj2, null, null, null, false, null, null, null, $composer, 6, 508);
                mutableState = $instDropdownExpanded$delegate;
                composer = $composer;
                str = str3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$330$lambda$329(MutableState $instDropdownExpanded$delegate, MutableState $showManageInstitutionsDialog$delegate) {
        FinancialAssetForm$lambda$49($instDropdownExpanded$delegate, false);
        FinancialAssetForm$lambda$84($showManageInstitutionsDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0431  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$340$lambda$337(final java.lang.String r67, androidx.compose.runtime.MutableState r68, final androidx.compose.runtime.MutableState r69, final androidx.compose.runtime.MutableState r70, final androidx.compose.runtime.MutableState r71, final androidx.compose.runtime.MutableState r72, final androidx.compose.runtime.MutableState r73, androidx.compose.runtime.Composer r74, int r75) {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$340$lambda$337(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$340$lambda$337$lambda$336$lambda$335$lambda$332$lambda$331(String $instName, MutableState $instDropdownExpanded$delegate, MutableState $editingInstitutionName$delegate, MutableState $institutionInputName$delegate, MutableState $showManageInstitutionsDialog$delegate) {
        FinancialAssetForm$lambda$49($instDropdownExpanded$delegate, false);
        $editingInstitutionName$delegate.setValue($instName);
        Intrinsics.checkNotNull($instName);
        $institutionInputName$delegate.setValue($instName);
        FinancialAssetForm$lambda$84($showManageInstitutionsDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$340$lambda$337$lambda$336$lambda$335$lambda$334$lambda$333(String $instName, MutableState $instDropdownExpanded$delegate, MutableState $institutionToDelete$delegate) {
        FinancialAssetForm$lambda$49($instDropdownExpanded$delegate, false);
        $institutionToDelete$delegate.setValue($instName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$342$lambda$341$lambda$340$lambda$339$lambda$338(String $instName, MutableState $institution$delegate, MutableState $instDropdownExpanded$delegate) {
        Intrinsics.checkNotNull($instName);
        $institution$delegate.setValue($instName);
        FinancialAssetForm$lambda$49($instDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$345$lambda$344$lambda$343(MutableState $showManageAccountNumbersDialog$delegate) {
        FinancialAssetForm$lambda$102($showManageAccountNumbersDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$347$lambda$346(MutableState $accountNumber$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $accountNumber$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$348(boolean $isStockCategory, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1425@68681L80:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1487310814, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1425)");
            }
            TextKt.m2693Text4IGK_g($isStockCategory ? "e.g. 1208160012345678" : "e.g. x1234 or FOL-9021", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$351(final MutableState $accNoDropdownExpanded$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1434@69077L50,1433@69031L439:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1384014620, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1433)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1401809714, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda131
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$367$lambda$351$lambda$350$lambda$349(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "account_number_dropdown_toggle"), false, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.m7011getLambda$958510049$app(), $composer, 196662, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$351$lambda$350$lambda$349(MutableState $accNoDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$52($accNoDropdownExpanded$delegate, !FinancialAssetForm$lambda$51($accNoDropdownExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$353$lambda$352(MutableState $accNoDropdownExpanded$delegate) {
        FinancialAssetForm$lambda$52($accNoDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$366(MutableState $accNoDropdownExpanded$delegate, final MutableState $showManageAccountNumbersDialog$delegate, MutableState $accountNumbersList$delegate, final MutableState $accountNumber$delegate, final MutableState $editingAccountNumberName$delegate, final MutableState $accountNumberInputName$delegate, final MutableState $accountNumberToDelete$delegate, ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        ComposableLambda composableLambda;
        final MutableState mutableState = $accNoDropdownExpanded$delegate;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation($composer, "C1470@70704L139,1453@69842L1019,1476@70879L19,*1480@71024L2827,1528@73887L136,1479@70975L3070:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1955865398, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1453)");
            }
            Function2<Composer, Integer, Unit> lambda$1371755258$app = ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1371755258$app();
            ComposerKt.sourceInformationMarkerStart($composer, 1609056469, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda139
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$355$lambda$354(MutableState.this, $showManageAccountNumbersDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            String str = "CC(remember):FinancialAssetForm.kt#9igjgp";
            AndroidMenu_androidKt.DropdownMenuItem(lambda$1371755258$app, (Function0) obj, null, null, null, false, null, null, null, $composer, 54, 508);
            Composer composer = $composer;
            DividerKt.m2072HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            for (final String str2 : FinancialAssetForm$lambda$98($accountNumbersList$delegate)) {
                String str3 = str;
                final MutableState mutableState2 = mutableState;
                ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(911025738, true, new Function2() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda140
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$365$lambda$362(str2, $accountNumber$delegate, mutableState, $editingAccountNumberName$delegate, $accountNumberInputName$delegate, $showManageAccountNumbersDialog$delegate, $accountNumberToDelete$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                ComposerKt.sourceInformationMarkerStart(composer, -424428414, str3);
                boolean changed = composer.changed(str2);
                Object rememberedValue2 = $composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    composableLambda = rememberComposableLambda;
                    obj2 = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda142
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$365$lambda$364$lambda$363(str2, $accountNumber$delegate, mutableState2);
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                } else {
                    composableLambda = rememberComposableLambda;
                    obj2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AndroidMenu_androidKt.DropdownMenuItem(composableLambda, (Function0) obj2, null, null, null, false, null, null, null, $composer, 6, 508);
                mutableState = $accNoDropdownExpanded$delegate;
                composer = $composer;
                str = str3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$355$lambda$354(MutableState $accNoDropdownExpanded$delegate, MutableState $showManageAccountNumbersDialog$delegate) {
        FinancialAssetForm$lambda$52($accNoDropdownExpanded$delegate, false);
        FinancialAssetForm$lambda$102($showManageAccountNumbersDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0431  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$365$lambda$362(final java.lang.String r67, androidx.compose.runtime.MutableState r68, final androidx.compose.runtime.MutableState r69, final androidx.compose.runtime.MutableState r70, final androidx.compose.runtime.MutableState r71, final androidx.compose.runtime.MutableState r72, final androidx.compose.runtime.MutableState r73, androidx.compose.runtime.Composer r74, int r75) {
        /*
            Method dump skipped, instructions count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$365$lambda$362(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$365$lambda$362$lambda$361$lambda$360$lambda$357$lambda$356(String $accNum, MutableState $accNoDropdownExpanded$delegate, MutableState $editingAccountNumberName$delegate, MutableState $accountNumberInputName$delegate, MutableState $showManageAccountNumbersDialog$delegate) {
        FinancialAssetForm$lambda$52($accNoDropdownExpanded$delegate, false);
        $editingAccountNumberName$delegate.setValue($accNum);
        Intrinsics.checkNotNull($accNum);
        $accountNumberInputName$delegate.setValue($accNum);
        FinancialAssetForm$lambda$102($showManageAccountNumbersDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$365$lambda$362$lambda$361$lambda$360$lambda$359$lambda$358(String $accNum, MutableState $accNoDropdownExpanded$delegate, MutableState $accountNumberToDelete$delegate) {
        FinancialAssetForm$lambda$52($accNoDropdownExpanded$delegate, false);
        $accountNumberToDelete$delegate.setValue($accNum);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$367$lambda$366$lambda$365$lambda$364$lambda$363(String $accNum, MutableState $accountNumber$delegate, MutableState $accNoDropdownExpanded$delegate) {
        Intrinsics.checkNotNull($accNum);
        $accountNumber$delegate.setValue($accNum);
        FinancialAssetForm$lambda$52($accNoDropdownExpanded$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0b0a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0bc3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0cd1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0cdd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0d14  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0d86  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0d91  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0e1d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0e8f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0e9a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0f1e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0ff0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x1055  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x1065  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x1075  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x1085  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x1115  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x107a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x106a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x105a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0ffe  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0f30  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0ea8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0e92  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0e33  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0da3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0d89  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0d2a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0ce3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0c05  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0b20  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0a8b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0a19  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0994 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x094b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x081f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x07d6  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x06fe A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x035c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0945  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x097e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x09fe  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0a6c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$411(final androidx.compose.runtime.MutableState r134, final androidx.compose.runtime.MutableState r135, androidx.compose.foundation.lazy.LazyListState r136, final androidx.compose.runtime.MutableState r137, final androidx.compose.runtime.MutableState r138, final androidx.compose.runtime.MutableState r139, final androidx.compose.runtime.MutableState r140, final androidx.compose.runtime.MutableState r141, final androidx.compose.runtime.snapshots.SnapshotStateList r142, final androidx.compose.runtime.MutableState r143, final androidx.compose.runtime.MutableState r144, final androidx.compose.runtime.MutableState r145, final androidx.compose.runtime.MutableState r146, final androidx.compose.runtime.MutableState r147, androidx.compose.runtime.MutableState r148, final androidx.compose.runtime.MutableState r149, final androidx.compose.runtime.MutableState r150, final androidx.compose.runtime.MutableState r151, final androidx.compose.runtime.MutableState r152, androidx.compose.runtime.MutableState r153, androidx.compose.foundation.layout.ColumnScope r154, androidx.compose.runtime.Composer r155, int r156) {
        /*
            Method dump skipped, instructions count: 4379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$411(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.lazy.LazyListState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.snapshots.SnapshotStateList, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$372$lambda$371(androidx.compose.runtime.MutableState r51, androidx.compose.runtime.MutableState r52, androidx.compose.runtime.Composer r53, int r54) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$372$lambda$371(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$381$lambda$380$lambda$374$lambda$373(MutableState $customSymbol$delegate, MutableState $customName$delegate, MutableState $customExchange$delegate, MutableState $customPriceStr$delegate, MutableState $showAddStockDialog$delegate) {
        $customSymbol$delegate.setValue("");
        $customName$delegate.setValue("");
        $customExchange$delegate.setValue("NSE");
        $customPriceStr$delegate.setValue("");
        FinancialAssetForm$lambda$143($showAddStockDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$381$lambda$380$lambda$377$lambda$376(SnapshotStateList $stockList, MutableState $selectedStockSymbol$delegate, MutableState $stockToEdit$delegate, MutableState $customSymbol$delegate, MutableState $customName$delegate, MutableState $customExchange$delegate, MutableState $customPriceStr$delegate) {
        Object obj;
        Iterator<T> it = $stockList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((StockQuote) obj).getSymbol(), FinancialAssetForm$lambda$163($selectedStockSymbol$delegate))) {
                break;
            }
        }
        StockQuote current = (StockQuote) obj;
        if (current != null) {
            $stockToEdit$delegate.setValue(current);
            $customSymbol$delegate.setValue(current.getSymbol());
            $customName$delegate.setValue(current.getName());
            $customExchange$delegate.setValue(current.getExchange());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(current.getCurrentPrice())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            $customPriceStr$delegate.setValue(format);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$381$lambda$380$lambda$379$lambda$378(SnapshotStateList $stockList, MutableState $showDeleteStockDialog$delegate) {
        if (!$stockList.isEmpty()) {
            FinancialAssetForm$lambda$149($showDeleteStockDialog$delegate, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388(final SnapshotStateList $stockList, final MutableState $customSymbol$delegate, final MutableState $customName$delegate, final MutableState $customExchange$delegate, final MutableState $customPriceStr$delegate, final MutableState $showAddStockDialog$delegate, final MutableState $selectedStockSymbol$delegate, final MutableState $selectedStockName$delegate, final MutableState $exchangeName$delegate, final MutableState $marketPricePerShareStr$delegate, final MutableState $stockQuoteChangePercent$delegate, final MutableState $isQuotePositive$delegate, final MutableState $title$delegate, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyListScope.item$default(LazyRow, "action_chip_add_new", null, ComposableLambdaKt.composableLambdaInstance(1022093442, true, new Function3() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda77
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$lambda$384(MutableState.this, $customName$delegate, $customExchange$delegate, $customPriceStr$delegate, $showAddStockDialog$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        final SnapshotStateList snapshotStateList = $stockList;
        final Function1 function1 = new Function1() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda88
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$lambda$385((StockQuote) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((StockQuote) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(StockQuote stockQuote) {
                return null;
            }
        };
        LazyRow.items(snapshotStateList.size(), new Function1<Integer, Object>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(snapshotStateList.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke(snapshotStateList.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                String FinancialAssetForm$lambda$163;
                boolean z;
                final boolean z2;
                Composer composer;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty & 14;
                final StockQuote stockQuote = (StockQuote) snapshotStateList.get(it);
                $composer.startReplaceGroup(-816686801);
                ComposerKt.sourceInformation($composer, "C*1744@85908L772,1755@86726L430,1763@87319L11,1764@87415L11,1762@87222L252,1742@85791L1717:FinancialAssetForm.kt#qonjpd");
                FinancialAssetForm$lambda$163 = FinancialAssetFormKt.FinancialAssetForm$lambda$163($selectedStockSymbol$delegate);
                boolean areEqual = Intrinsics.areEqual(FinancialAssetForm$lambda$163, stockQuote.getSymbol());
                ComposerKt.sourceInformationMarkerStart($composer, -441981298, "CC(remember):FinancialAssetForm.kt#9igjgp");
                boolean z3 = (((i & 112) ^ 48) > 32 && $composer.changed(stockQuote)) || (i & 48) == 32;
                Object rememberedValue = $composer.rememberedValue();
                if (z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final SnapshotStateList snapshotStateList2 = $stockList;
                    final MutableState mutableState = $selectedStockSymbol$delegate;
                    final MutableState mutableState2 = $selectedStockName$delegate;
                    final MutableState mutableState3 = $exchangeName$delegate;
                    final MutableState mutableState4 = $marketPricePerShareStr$delegate;
                    final MutableState mutableState5 = $stockQuoteChangePercent$delegate;
                    final MutableState mutableState6 = $isQuotePositive$delegate;
                    final MutableState mutableState7 = $title$delegate;
                    z = true;
                    z2 = areEqual;
                    composer = $composer;
                    rememberedValue = new Function0<Unit>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$2$8$1$2$2$1$3$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            String FinancialAssetForm$lambda$1;
                            String FinancialAssetForm$lambda$12;
                            mutableState.setValue(StockQuote.this.getSymbol());
                            mutableState2.setValue(StockQuote.this.getName());
                            mutableState3.setValue(StockQuote.this.getExchange());
                            MutableState<String> mutableState8 = mutableState4;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            boolean z4 = true;
                            String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(StockQuote.this.getCurrentPrice())}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            mutableState8.setValue(format);
                            FinancialAssetFormKt.FinancialAssetForm$lambda$184(mutableState5, StockQuote.this.getChangePercent());
                            FinancialAssetFormKt.FinancialAssetForm$lambda$187(mutableState6, StockQuote.this.isPositive());
                            FinancialAssetForm$lambda$1 = FinancialAssetFormKt.FinancialAssetForm$lambda$1(mutableState7);
                            if (!StringsKt.isBlank(FinancialAssetForm$lambda$1)) {
                                Iterable iterable = snapshotStateList2;
                                MutableState<String> mutableState9 = mutableState7;
                                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                                    Iterator<StockQuote> it2 = iterable.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            StockQuote stockQuote2 = (StockQuote) it2.next();
                                            FinancialAssetForm$lambda$12 = FinancialAssetFormKt.FinancialAssetForm$lambda$1(mutableState9);
                                            if (StringsKt.contains$default((CharSequence) FinancialAssetForm$lambda$12, (CharSequence) stockQuote2.getSymbol(), false, 2, (Object) null)) {
                                                break;
                                            }
                                        } else {
                                            z4 = false;
                                            break;
                                        }
                                    }
                                } else {
                                    z4 = false;
                                }
                                if (!z4) {
                                    return;
                                }
                            }
                            mutableState7.setValue(StockQuote.this.getSymbol() + " - " + StockQuote.this.getName());
                        }
                    };
                    $composer.updateRememberedValue(rememberedValue);
                } else {
                    composer = $composer;
                    z2 = areEqual;
                    z = true;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Composer composer2 = composer;
                ChipKt.FilterChip(z2, (Function0) rememberedValue, ComposableLambdaKt.rememberComposableLambda(-1189409443, z, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$2$8$1$2$2$1$3$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C1756@86768L350:FinancialAssetForm.kt#qonjpd");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1189409443, $changed2, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1756)");
                        }
                        String symbol = StockQuote.this.getSymbol();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(Locale.US, "%.0f", Arrays.copyOf(new Object[]{Double.valueOf(StockQuote.this.getCurrentPrice())}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        TextKt.m2693Text4IGK_g(symbol + " (₹" + format + ")", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, z2 ? FontWeight.INSTANCE.getBold() : FontWeight.INSTANCE.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131030);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), null, false, null, null, null, FilterChipDefaults.INSTANCE.m2111filterChipColorsXqyqHi0(0L, 0L, 0L, 0L, 0L, 0L, 0L, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimary(), 0L, 0L, composer2, 0, FilterChipDefaults.$stable << 6, 3455), null, null, null, composer2, 384, 0, 3832);
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$lambda$384(final MutableState $customSymbol$delegate, final MutableState $customName$delegate, final MutableState $customExchange$delegate, final MutableState $customPriceStr$delegate, final MutableState $showAddStockDialog$delegate, LazyItemScope item, Composer $composer, int $changed) {
        long m4157copywmQWz5c;
        Object obj;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C1734@85380L11,1733@85291L174,1710@83925L342,1708@83813L1686:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1022093442, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1708)");
            }
            FilterChipDefaults filterChipDefaults = FilterChipDefaults.INSTANCE;
            m4157copywmQWz5c = Color.m4157copywmQWz5c(r4, (r12 & 1) != 0 ? Color.m4161getAlphaimpl(r4) : 0.6f, (r12 & 2) != 0 ? Color.m4165getRedimpl(r4) : 0.0f, (r12 & 4) != 0 ? Color.m4164getGreenimpl(r4) : 0.0f, (r12 & 8) != 0 ? Color.m4162getBlueimpl(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer()) : 0.0f);
            SelectableChipColors m2111filterChipColorsXqyqHi0 = filterChipDefaults.m2111filterChipColorsXqyqHi0(m4157copywmQWz5c, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 0, FilterChipDefaults.$stable << 6, 4094);
            ComposerKt.sourceInformationMarkerStart($composer, -1315708008, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda186
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$lambda$384$lambda$383$lambda$382(MutableState.this, $customName$delegate, $customExchange$delegate, $customPriceStr$delegate, $showAddStockDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ChipKt.FilterChip(false, (Function0) obj, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1128991855$app(), null, false, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$2117107916$app(), null, null, m2111filterChipColorsXqyqHi0, null, null, null, $composer, 197046, 0, 3800);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$lambda$384$lambda$383$lambda$382(MutableState $customSymbol$delegate, MutableState $customName$delegate, MutableState $customExchange$delegate, MutableState $customPriceStr$delegate, MutableState $showAddStockDialog$delegate) {
        $customSymbol$delegate.setValue("");
        $customName$delegate.setValue("");
        $customExchange$delegate.setValue("NSE");
        $customPriceStr$delegate.setValue("");
        FinancialAssetForm$lambda$143($showAddStockDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$390$lambda$389$lambda$388$lambda$385(StockQuote it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSymbol();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$402$lambda$394$lambda$393(MutableState $sharesQuantityStr$delegate, MutableState $stockQuantityError$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $sharesQuantityStr$delegate.setValue(it);
        if (FinancialAssetForm$lambda$190($stockQuantityError$delegate) != null) {
            $stockQuantityError$delegate.setValue(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$402$lambda$392$lambda$391(String $err, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1787@88553L11,1787@88514L57:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1217847447, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1787)");
            }
            TextKt.m2693Text4IGK_g($err, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$402$lambda$398$lambda$397(MutableState $marketPricePerShareStr$delegate, MutableState $stockPriceError$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $marketPricePerShareStr$delegate.setValue(it);
        if (FinancialAssetForm$lambda$193($stockPriceError$delegate) != null) {
            $stockPriceError$delegate.setValue(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$402$lambda$401(final MutableState $marketPricePerShareStr$delegate, final MutableState $stockQuoteChangePercent$delegate, final MutableState $isQuotePositive$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C1806@89571L670,1806@89550L1117:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1663649417, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1806)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1039253195, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda108
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$402$lambda$401$lambda$400$lambda$399(MutableState.this, $stockQuoteChangePercent$delegate, $isQuotePositive$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) obj, null, false, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$112573754$app(), $composer, 196614, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$402$lambda$401$lambda$400$lambda$399(MutableState $marketPricePerShareStr$delegate, MutableState $stockQuoteChangePercent$delegate, MutableState $isQuotePositive$delegate) {
        Double doubleOrNull = StringsKt.toDoubleOrNull(FinancialAssetForm$lambda$176($marketPricePerShareStr$delegate));
        double currentPriceNum = doubleOrNull != null ? doubleOrNull.doubleValue() : 1000.0d;
        double delta = RangesKt.random(new IntRange(-15, 25), Random.INSTANCE) / 10.0d;
        double newPrice = RangesKt.coerceAtLeast(currentPriceNum + delta, 1.0d);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(newPrice)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        $marketPricePerShareStr$delegate.setValue(format);
        FinancialAssetForm$lambda$184($stockQuoteChangePercent$delegate, (delta / currentPriceNum) * 100.0d);
        FinancialAssetForm$lambda$187($isQuotePositive$delegate, delta >= 0.0d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$402$lambda$396$lambda$395(String $err, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1825@90910L11,1825@90871L57:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-27986909, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1825)");
            }
            TextKt.m2693Text4IGK_g($err, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$404$lambda$403(MutableState $buyPricePerShareStr$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $buyPricePerShareStr$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x039c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$409(double r107, double r109, double r111, androidx.compose.runtime.Composer r113, int r114) {
        /*
            Method dump skipped, instructions count: 1804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$428$lambda$411$lambda$410$lambda$409(double, double, double, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$415$lambda$414(MutableState $currentValueStr$delegate, MutableState $currentValueError$delegate, String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        $currentValueStr$delegate.setValue(input);
        if (FinancialAssetForm$lambda$199($currentValueError$delegate) != null) {
            String cleaned = FinancialAssetForm$validateAndCleanCurrencyInput(input);
            if (StringsKt.toDoubleOrNull(cleaned) != null) {
                $currentValueError$delegate.setValue(null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$416(boolean $isPaidLoanCategory, MutableState $isLiability$delegate, Composer $composer, int $changed) {
        String str;
        ComposerKt.sourceInformation($composer, "C1925@96234L322:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2010355817, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous> (FinancialAssetForm.kt:1925)");
            }
            if ($isPaidLoanCategory) {
                str = "Loan Given / Principal Amount (₹) *";
            } else {
                str = FinancialAssetForm$lambda$24($isLiability$delegate) ? "Current Outstanding Amount (₹) *" : "Current Valuation / Balance (₹) *";
            }
            TextKt.m2693Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$417(MutableState $currentValueError$delegate, Composer $composer, int $changed) {
        Composer $composer2;
        ComposerKt.sourceInformation($composer, "C:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-947999546, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous> (FinancialAssetForm.kt:1941)");
            }
            if (FinancialAssetForm$lambda$199($currentValueError$delegate) != null) {
                $composer.startReplaceGroup(1850524682);
                ComposerKt.sourceInformation($composer, "1945@97137L11,1942@96954L226");
                $composer2 = $composer;
                IconKt.m2150Iconww6aTOc(ErrorOutlineKt.getErrorOutline(Icons.INSTANCE.getDefault()), "Error", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), $composer2, 48, 4);
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(1754362620);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$413$lambda$412(String $err, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1951@97401L11,1951@97362L57:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1869883636, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1951)");
            }
            TextKt.m2693Text4IGK_g($err, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$421$lambda$420(MutableState $investedValueStr$delegate, MutableState $investedValueError$delegate, String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        $investedValueStr$delegate.setValue(input);
        if (FinancialAssetForm$lambda$202($investedValueError$delegate) != null) {
            String cleaned = FinancialAssetForm$validateAndCleanCurrencyInput(input);
            if ((cleaned.length() == 0) || StringsKt.toDoubleOrNull(cleaned) != null) {
                $investedValueError$delegate.setValue(null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$419$lambda$418(String $err, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1984@98967L11,1984@98928L57:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-171735851, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:1984)");
            }
            TextKt.m2693Text4IGK_g($err, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$423$lambda$422(MutableState $notes$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $notes$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$427$lambda$425$lambda$424(boolean $isStockCategory, FinancialItem $itemToEdit, Function1 $onSave, boolean $isMFOnly, MutableState $title$delegate, MutableState $selectedStockSymbol$delegate, MutableState $selectedStockName$delegate, MutableState $titleError$delegate, MutableState $sharesQuantityStr$delegate, MutableState $stockQuantityError$delegate, MutableState $marketPricePerShareStr$delegate, MutableState $stockPriceError$delegate, MutableState $buyPricePerShareStr$delegate, MutableState $currentValueStr$delegate, MutableState $investedValueStr$delegate, MutableState $currentValueError$delegate, MutableState $investedValueError$delegate, MutableState $notes$delegate, MutableState $institution$delegate, MutableState $accountNumber$delegate, MutableState $owner$delegate, MutableState $category$delegate, MutableState $isLiability$delegate, MutableState $shouldDeductOrAddOpposite$delegate, MutableState $sourceAccountTitle$delegate) {
        String finalNotes;
        if (FinancialAssetForm$performValidation($isStockCategory, $isMFOnly, $title$delegate, $selectedStockSymbol$delegate, $selectedStockName$delegate, $titleError$delegate, $sharesQuantityStr$delegate, $stockQuantityError$delegate, $marketPricePerShareStr$delegate, $stockPriceError$delegate, $buyPricePerShareStr$delegate, $currentValueStr$delegate, $investedValueStr$delegate, $currentValueError$delegate, $investedValueError$delegate)) {
            String cleanedCurVal = FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$17($currentValueStr$delegate));
            Double doubleOrNull = StringsKt.toDoubleOrNull(cleanedCurVal);
            double curVal = doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d;
            String cleanedInvVal = FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$21($investedValueStr$delegate));
            Double doubleOrNull2 = StringsKt.toDoubleOrNull(cleanedInvVal);
            double invVal = doubleOrNull2 != null ? doubleOrNull2.doubleValue() : curVal;
            if ($isStockCategory) {
                String stockNote = "[Google Finance: " + FinancialAssetForm$lambda$172($sharesQuantityStr$delegate) + " shares of " + FinancialAssetForm$lambda$163($selectedStockSymbol$delegate) + " @ ₹" + FinancialAssetForm$lambda$176($marketPricePerShareStr$delegate) + "]";
                finalNotes = StringsKt.isBlank(FinancialAssetForm$lambda$27($notes$delegate)) ? stockNote : FinancialAssetForm$lambda$27($notes$delegate) + "\n" + stockNote;
            } else {
                finalNotes = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$27($notes$delegate)).toString();
            }
            FinancialItem newItem = new FinancialItem($itemToEdit != null ? $itemToEdit.getId() : 0L, StringsKt.trim((CharSequence) FinancialAssetForm$lambda$1($title$delegate)).toString(), StringsKt.trim((CharSequence) FinancialAssetForm$lambda$4($institution$delegate)).toString(), StringsKt.trim((CharSequence) FinancialAssetForm$lambda$7($accountNumber$delegate)).toString(), FinancialAssetForm$lambda$10($owner$delegate), FinancialAssetForm$lambda$13($category$delegate), curVal, invVal, FinancialAssetForm$lambda$24($isLiability$delegate), finalNotes, FinancialAssetForm$lambda$33($shouldDeductOrAddOpposite$delegate) ? StringsKt.trim((CharSequence) FinancialAssetForm$lambda$30($sourceAccountTitle$delegate)).toString() : "", System.currentTimeMillis());
            $onSave.invoke(newItem);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$428$lambda$427$lambda$426(String $submitButtonText, RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C2055@101963L185,2060@102165L22:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-722460280, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:2055)");
            }
            IconKt.m2150Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, PaddingKt.m674paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m6622constructorimpl(4), 0.0f, 11, null), 0L, $composer, 432, 8);
            TextKt.m2693Text4IGK_g($submitButtonText, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String FinancialAssetForm$lambda$430(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$433$lambda$432(MutableState $showAddStockDialog$delegate) {
        FinancialAssetForm$lambda$143($showAddStockDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$452(final androidx.compose.runtime.MutableState r55, final androidx.compose.runtime.MutableState r56, final androidx.compose.runtime.MutableState r57, final androidx.compose.runtime.MutableState r58, androidx.compose.runtime.MutableState r59, androidx.compose.runtime.Composer r60, int r61) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$452(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$452$lambda$451$lambda$443$lambda$442(MutableState $customSymbol$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String upperCase = it.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        $customSymbol$delegate.setValue(upperCase);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$452$lambda$451$lambda$445$lambda$444(MutableState $customName$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $customName$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$452$lambda$451$lambda$447$lambda$446(MutableState $customExchange$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String upperCase = it.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        $customExchange$delegate.setValue(upperCase);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$452$lambda$451$lambda$449$lambda$448(MutableState $customPriceStr$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $customPriceStr$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$438(final CoroutineScope $coroutineScope, final LazyListState $stockLazyListState, final SnapshotStateList $stockList, final MutableState $customSymbol$delegate, final MutableState $customName$delegate, final MutableState $customPriceStr$delegate, final MutableState $dialogError$delegate, final MutableState $customExchange$delegate, final MutableState $selectedStockSymbol$delegate, final MutableState $selectedStockName$delegate, final MutableState $exchangeName$delegate, final MutableState $marketPricePerShareStr$delegate, final MutableState $title$delegate, final MutableState $sharesQuantityStr$delegate, final MutableState $buyPricePerShareStr$delegate, final MutableState $currentValueStr$delegate, final MutableState $investedValueStr$delegate, final MutableState $showAddStockDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2112@104733L2061,2111@104695L2245:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(978247441, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2111)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -502043170, "CC(remember):FinancialAssetForm.kt#9igjgp");
            boolean changedInstance = $composer.changedInstance($coroutineScope) | $composer.changed($stockLazyListState);
            Object rememberedValue = $composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda218
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$438$lambda$437$lambda$436(SnapshotStateList.this, $coroutineScope, $customSymbol$delegate, $customName$delegate, $customPriceStr$delegate, $dialogError$delegate, $customExchange$delegate, $selectedStockSymbol$delegate, $selectedStockName$delegate, $exchangeName$delegate, $marketPricePerShareStr$delegate, $title$delegate, $sharesQuantityStr$delegate, $buyPricePerShareStr$delegate, $currentValueStr$delegate, $investedValueStr$delegate, $stockLazyListState, $showAddStockDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "confirm_add_stock"), false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1546618145$app(), $composer, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$438$lambda$437$lambda$436(SnapshotStateList $stockList, CoroutineScope $coroutineScope, MutableState $customSymbol$delegate, MutableState $customName$delegate, MutableState $customPriceStr$delegate, MutableState $dialogError$delegate, MutableState $customExchange$delegate, MutableState $selectedStockSymbol$delegate, MutableState $selectedStockName$delegate, MutableState $exchangeName$delegate, MutableState $marketPricePerShareStr$delegate, MutableState $title$delegate, MutableState $sharesQuantityStr$delegate, MutableState $buyPricePerShareStr$delegate, MutableState $currentValueStr$delegate, MutableState $investedValueStr$delegate, LazyListState $stockLazyListState, MutableState $showAddStockDialog$delegate) {
        final String sym = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$151($customSymbol$delegate)).toString();
        String name = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$154($customName$delegate)).toString();
        Double price = StringsKt.toDoubleOrNull(FinancialAssetForm$lambda$160($customPriceStr$delegate));
        if (!(sym.length() == 0)) {
            if (!(name.length() == 0) && price != null) {
                if (price.doubleValue() > 0.0d) {
                    String obj = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$157($customExchange$delegate)).toString();
                    if (obj.length() == 0) {
                        obj = "NSE";
                    }
                    StockQuote newStock = new StockQuote(sym, name, obj, price.doubleValue(), 1.2d, true);
                    CollectionsKt.removeAll((List) $stockList, new Function1() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda125
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(FinancialAssetFormKt.FinancialAssetForm$lambda$438$lambda$437$lambda$436$lambda$435(sym, (StockQuote) obj2));
                        }
                    });
                    $stockList.add(0, newStock);
                    $selectedStockSymbol$delegate.setValue(newStock.getSymbol());
                    $selectedStockName$delegate.setValue(newStock.getName());
                    $exchangeName$delegate.setValue(newStock.getExchange());
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(newStock.getCurrentPrice())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    $marketPricePerShareStr$delegate.setValue(format);
                    $title$delegate.setValue(newStock.getSymbol() + " - " + newStock.getName());
                    Double doubleOrNull = StringsKt.toDoubleOrNull(FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$172($sharesQuantityStr$delegate)));
                    double qty = doubleOrNull != null ? doubleOrNull.doubleValue() : 10.0d;
                    Double doubleOrNull2 = StringsKt.toDoubleOrNull(FinancialAssetForm$validateAndCleanCurrencyInput(FinancialAssetForm$lambda$180($buyPricePerShareStr$delegate)));
                    double buyP = doubleOrNull2 != null ? doubleOrNull2.doubleValue() : newStock.getCurrentPrice();
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(newStock.getCurrentPrice() * qty)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    $currentValueStr$delegate.setValue(format2);
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String format3 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(qty * buyP)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                    $investedValueStr$delegate.setValue(format3);
                    BuildersKt.launch$default($coroutineScope, null, null, new FinancialAssetFormKt$FinancialAssetForm$4$1$1$2($stockLazyListState, null), 3, null);
                    FinancialAssetForm$lambda$143($showAddStockDialog$delegate, false);
                    return Unit.INSTANCE;
                }
                $dialogError$delegate.setValue("Please enter valid symbol, name and price (> 0).");
                return Unit.INSTANCE;
            }
        }
        $dialogError$delegate.setValue("Please enter valid symbol, name and price (> 0).");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean FinancialAssetForm$lambda$438$lambda$437$lambda$436$lambda$435(String $sym, StockQuote it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.equals(it.getSymbol(), $sym, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$441(final MutableState $showAddStockDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2156@107023L30,2156@107002L107:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(288415951, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2156)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -2005144051, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda155
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$441$lambda$440$lambda$439(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.m6989getLambda$348759374$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$441$lambda$440$lambda$439(MutableState $showAddStockDialog$delegate) {
        FinancialAssetForm$lambda$143($showAddStockDialog$delegate, false);
        return Unit.INSTANCE;
    }

    private static final String FinancialAssetForm$lambda$454(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$457$lambda$456(MutableState $stockToEdit$delegate) {
        $stockToEdit$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$476(final androidx.compose.runtime.MutableState r55, final androidx.compose.runtime.MutableState r56, final androidx.compose.runtime.MutableState r57, final androidx.compose.runtime.MutableState r58, androidx.compose.runtime.MutableState r59, androidx.compose.runtime.Composer r60, int r61) {
        /*
            Method dump skipped, instructions count: 1040
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$476(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$476$lambda$475$lambda$467$lambda$466(MutableState $customSymbol$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String upperCase = it.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        $customSymbol$delegate.setValue(upperCase);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$476$lambda$475$lambda$469$lambda$468(MutableState $customName$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $customName$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$476$lambda$475$lambda$471$lambda$470(MutableState $customExchange$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String upperCase = it.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        $customExchange$delegate.setValue(upperCase);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$476$lambda$475$lambda$473$lambda$472(MutableState $customPriceStr$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $customPriceStr$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$462(final SnapshotStateList $stockList, final MutableState $customSymbol$delegate, final MutableState $customName$delegate, final MutableState $customPriceStr$delegate, final MutableState $dialogError$delegate, final MutableState $customExchange$delegate, final MutableState $stockToEdit$delegate, final MutableState $selectedStockSymbol$delegate, final MutableState $selectedStockName$delegate, final MutableState $exchangeName$delegate, final MutableState $marketPricePerShareStr$delegate, final MutableState $title$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2207@109465L1680,2206@109427L1870:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1607617352, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2206)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1267947816, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda173
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$462$lambda$461$lambda$460(SnapshotStateList.this, $customSymbol$delegate, $customName$delegate, $customPriceStr$delegate, $dialogError$delegate, $customExchange$delegate, $stockToEdit$delegate, $selectedStockSymbol$delegate, $selectedStockName$delegate, $exchangeName$delegate, $marketPricePerShareStr$delegate, $title$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, TestTagKt.testTag(Modifier.INSTANCE, "confirm_modify_stock"), false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.m6981getLambda$1943949992$app(), $composer, 805306422, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$462$lambda$461$lambda$460(SnapshotStateList $stockList, MutableState $customSymbol$delegate, MutableState $customName$delegate, MutableState $customPriceStr$delegate, MutableState $dialogError$delegate, MutableState $customExchange$delegate, MutableState $stockToEdit$delegate, MutableState $selectedStockSymbol$delegate, MutableState $selectedStockName$delegate, MutableState $exchangeName$delegate, MutableState $marketPricePerShareStr$delegate, MutableState $title$delegate) {
        String sym = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$151($customSymbol$delegate)).toString();
        String name = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$154($customName$delegate)).toString();
        Double price = StringsKt.toDoubleOrNull(FinancialAssetForm$lambda$160($customPriceStr$delegate));
        if (!(sym.length() == 0)) {
            if (!(name.length() == 0) && price != null) {
                if (price.doubleValue() > 0.0d) {
                    String obj = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$157($customExchange$delegate)).toString();
                    if (obj.length() == 0) {
                        obj = "NSE";
                    }
                    String str = obj;
                    double doubleValue = price.doubleValue();
                    StockQuote FinancialAssetForm$lambda$145 = FinancialAssetForm$lambda$145($stockToEdit$delegate);
                    double changePercent = FinancialAssetForm$lambda$145 != null ? FinancialAssetForm$lambda$145.getChangePercent() : 0.8d;
                    StockQuote FinancialAssetForm$lambda$1452 = FinancialAssetForm$lambda$145($stockToEdit$delegate);
                    StockQuote updatedStock = new StockQuote(sym, name, str, doubleValue, changePercent, FinancialAssetForm$lambda$1452 != null ? FinancialAssetForm$lambda$1452.isPositive() : true);
                    int idx = 0;
                    Iterator it = $stockList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String symbol = ((StockQuote) it.next()).getSymbol();
                            StockQuote FinancialAssetForm$lambda$1453 = FinancialAssetForm$lambda$145($stockToEdit$delegate);
                            if (Intrinsics.areEqual(symbol, FinancialAssetForm$lambda$1453 != null ? FinancialAssetForm$lambda$1453.getSymbol() : null)) {
                                break;
                            }
                            idx++;
                        } else {
                            idx = -1;
                            break;
                        }
                    }
                    if (idx != -1) {
                        $stockList.set(idx, updatedStock);
                    } else {
                        $stockList.add(updatedStock);
                    }
                    $selectedStockSymbol$delegate.setValue(updatedStock.getSymbol());
                    $selectedStockName$delegate.setValue(updatedStock.getName());
                    $exchangeName$delegate.setValue(updatedStock.getExchange());
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(updatedStock.getCurrentPrice())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    $marketPricePerShareStr$delegate.setValue(format);
                    $title$delegate.setValue(updatedStock.getSymbol() + " - " + updatedStock.getName());
                    $stockToEdit$delegate.setValue(null);
                    return Unit.INSTANCE;
                }
                $dialogError$delegate.setValue("Please enter valid symbol, name and price (> 0).");
                return Unit.INSTANCE;
            }
        }
        $dialogError$delegate.setValue("Please enter valid symbol, name and price (> 0).");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$465(final MutableState $stockToEdit$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2246@111380L22,2246@111359L99:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(104519046, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2246)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1658556668, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda165
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$465$lambda$464$lambda$463(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1959355049$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$465$lambda$464$lambda$463(MutableState $stockToEdit$delegate) {
        $stockToEdit$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$478$lambda$477(MutableState $showDeleteStockDialog$delegate) {
        FinancialAssetForm$lambda$149($showDeleteStockDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$487(MutableState $selectedStockSymbol$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C2258@111720L84:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2066848612, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2258)");
            }
            TextKt.m2693Text4IGK_g("Are you sure you want to remove '" + FinancialAssetForm$lambda$163($selectedStockSymbol$delegate) + "' from your stock list?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$483(final SnapshotStateList $stockList, final MutableState $selectedStockSymbol$delegate, final MutableState $selectedStockName$delegate, final MutableState $exchangeName$delegate, final MutableState $marketPricePerShareStr$delegate, final MutableState $title$delegate, final MutableState $showDeleteStockDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2272@112621L11,2272@112577L62,2261@111892L639,2260@111854L931:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1529627081, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2260)");
            }
            ButtonColors m1809buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
            Modifier testTag = TestTagKt.testTag(Modifier.INSTANCE, "confirm_delete_stock");
            ComposerKt.sourceInformationMarkerStart($composer, 1092812040, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda107
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$483$lambda$482$lambda$481(SnapshotStateList.this, $selectedStockSymbol$delegate, $selectedStockName$delegate, $exchangeName$delegate, $marketPricePerShareStr$delegate, $title$delegate, $showDeleteStockDialog$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, testTag, false, null, m1809buttonColorsro_MJ88, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.m6984getLambda$2021940263$app(), $composer, 805306422, 492);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$483$lambda$482$lambda$481(SnapshotStateList $stockList, final MutableState $selectedStockSymbol$delegate, MutableState $selectedStockName$delegate, MutableState $exchangeName$delegate, MutableState $marketPricePerShareStr$delegate, MutableState $title$delegate, MutableState $showDeleteStockDialog$delegate) {
        CollectionsKt.removeAll((List) $stockList, new Function1() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda122
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(FinancialAssetFormKt.FinancialAssetForm$lambda$483$lambda$482$lambda$481$lambda$479(MutableState.this, (StockQuote) obj));
            }
        });
        StockQuote stockQuote = (StockQuote) CollectionsKt.firstOrNull((List) $stockList);
        if (stockQuote != null) {
            $selectedStockSymbol$delegate.setValue(stockQuote.getSymbol());
            $selectedStockName$delegate.setValue(stockQuote.getName());
            $exchangeName$delegate.setValue(stockQuote.getExchange());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(stockQuote.getCurrentPrice())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            $marketPricePerShareStr$delegate.setValue(format);
            $title$delegate.setValue(stockQuote.getSymbol() + " - " + stockQuote.getName());
        }
        FinancialAssetForm$lambda$149($showDeleteStockDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean FinancialAssetForm$lambda$483$lambda$482$lambda$481$lambda$479(MutableState $selectedStockSymbol$delegate, StockQuote it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it.getSymbol(), FinancialAssetForm$lambda$163($selectedStockSymbol$delegate));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$486(final MutableState $showDeleteStockDialog$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2279@112868L33,2279@112847L110:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(26528775, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2279)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -275649720, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$486$lambda$485$lambda$484(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1881364778$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$486$lambda$485$lambda$484(MutableState $showDeleteStockDialog$delegate) {
        FinancialAssetForm$lambda$149($showDeleteStockDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String FinancialAssetForm$lambda$489(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean FinancialAssetForm$lambda$492(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FinancialAssetForm$lambda$493(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$495$lambda$494(MutableState $showManageCategoriesDialog$delegate, MutableState $editingCategoryName$delegate) {
        FinancialAssetForm$lambda$134($showManageCategoriesDialog$delegate, false);
        $editingCategoryName$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$500(final androidx.compose.runtime.MutableState r74, final androidx.compose.runtime.MutableState r75, androidx.compose.runtime.Composer r76, int r77) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$500(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$500$lambda$499$lambda$498$lambda$497(MutableState $showManageCategoriesDialog$delegate, MutableState $editingCategoryName$delegate) {
        FinancialAssetForm$lambda$134($showManageCategoriesDialog$delegate, false);
        $editingCategoryName$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0a0b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0aff  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x094e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0674 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0625  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0788  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x08f5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0938  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x09b7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x09ea  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0a3b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0a67  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$530(final java.util.List r98, final androidx.compose.runtime.MutableState r99, final androidx.compose.runtime.MutableState r100, final androidx.compose.runtime.MutableState r101, final android.content.SharedPreferences r102, final androidx.compose.runtime.MutableState r103, final androidx.compose.runtime.MutableState r104, final androidx.compose.runtime.MutableState r105, androidx.compose.runtime.Composer r106, int r107) {
        /*
            Method dump skipped, instructions count: 2821
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$530(java.util.List, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, android.content.SharedPreferences, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$504$lambda$503(final List $categoryPresets, final MutableState $catInputName$delegate, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final Function1 function1 = new Function1() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$lambda$530$lambda$529$lambda$504$lambda$503$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((String) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(String str) {
                return null;
            }
        };
        LazyRow.items($categoryPresets.size(), null, new Function1<Integer, Object>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$lambda$530$lambda$529$lambda$504$lambda$503$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return Function1.this.invoke($categoryPresets.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$lambda$530$lambda$529$lambda$504$lambda$503$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                String FinancialAssetForm$lambda$489;
                Object obj;
                ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (($dirty & 147) == 146 && $composer.getSkipping()) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int i = $dirty & 14;
                final String str = (String) $categoryPresets.get(it);
                $composer.startReplaceGroup(128744823);
                ComposerKt.sourceInformation($composer, "C*2352@115802L93,2355@115937L34,2350@115657L344:FinancialAssetForm.kt#qonjpd");
                FinancialAssetForm$lambda$489 = FinancialAssetFormKt.FinancialAssetForm$lambda$489($catInputName$delegate);
                boolean equals = StringsKt.equals(FinancialAssetForm$lambda$489, str, true);
                ComposerKt.sourceInformationMarkerStart($composer, 1389630769, "CC(remember):FinancialAssetForm.kt#9igjgp");
                boolean z = (((i & 112) ^ 48) > 32 && $composer.changed(str)) || (i & 48) == 32;
                Object rememberedValue = $composer.rememberedValue();
                if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState = $catInputName$delegate;
                    obj = (Function0) new Function0<Unit>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$17$1$1$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            mutableState.setValue(str);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ChipKt.FilterChip(equals, (Function0) obj, ComposableLambdaKt.rememberComposableLambda(1990037601, true, new Function2<Composer, Integer, Unit>() { // from class: com.example.ui.components.FinancialAssetFormKt$FinancialAssetForm$17$1$1$1$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C2355@115939L30:FinancialAssetForm.kt#qonjpd");
                        if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1990037601, $changed2, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:2355)");
                            }
                            TextKt.m2693Text4IGK_g(str, (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer2.skipToGroupEnd();
                    }
                }, $composer, 54), null, false, null, null, null, null, null, null, null, $composer, 384, 0, 4088);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$506$lambda$505(MutableState $catInputName$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $catInputName$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$511$lambda$508$lambda$507(MutableState $catTypeIsLiability$delegate) {
        FinancialAssetForm$lambda$493($catTypeIsLiability$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$511$lambda$510$lambda$509(MutableState $catTypeIsLiability$delegate) {
        FinancialAssetForm$lambda$493($catTypeIsLiability$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$519$lambda$513$lambda$512(MutableState $editingCategoryName$delegate, MutableState $catInputName$delegate) {
        $editingCategoryName$delegate.setValue(null);
        $catInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$519$lambda$517$lambda$516(MutableState $catInputName$delegate, MutableState $editingCategoryName$delegate, MutableState $categoriesList$delegate, SharedPreferences $prefs, MutableState $category$delegate) {
        String trimmed = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$489($catInputName$delegate)).toString();
        if (!StringsKt.isBlank(trimmed)) {
            boolean z = true;
            if (FinancialAssetForm$lambda$136($editingCategoryName$delegate) != null) {
                String oldName = FinancialAssetForm$lambda$136($editingCategoryName$delegate);
                Intrinsics.checkNotNull(oldName);
                Iterable<String> FinancialAssetForm$lambda$130 = FinancialAssetForm$lambda$130($categoriesList$delegate);
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(FinancialAssetForm$lambda$130, 10));
                for (String str : FinancialAssetForm$lambda$130) {
                    if (StringsKt.equals(str, oldName, true)) {
                        str = trimmed;
                    }
                    arrayList.add(str);
                }
                List updated = (List) arrayList;
                FinancialAssetForm$saveCategoriesToPrefs($prefs, $categoriesList$delegate, updated);
                if (StringsKt.equals(FinancialAssetForm$lambda$13($category$delegate), oldName, true)) {
                    $category$delegate.setValue(trimmed);
                }
            } else {
                Iterable FinancialAssetForm$lambda$1302 = FinancialAssetForm$lambda$130($categoriesList$delegate);
                if (!(FinancialAssetForm$lambda$1302 instanceof Collection) || !((Collection) FinancialAssetForm$lambda$1302).isEmpty()) {
                    Iterator it = FinancialAssetForm$lambda$1302.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (StringsKt.equals((String) it.next(), trimmed, true)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    List updated2 = CollectionsKt.plus((Collection<? extends String>) FinancialAssetForm$lambda$130($categoriesList$delegate), trimmed);
                    FinancialAssetForm$saveCategoriesToPrefs($prefs, $categoriesList$delegate, updated2);
                }
                $category$delegate.setValue(trimmed);
            }
            $editingCategoryName$delegate.setValue(null);
            $catInputName$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$519$lambda$518(MutableState $editingCategoryName$delegate, RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C2451@120810L85,2452@120924L39,2453@120992L76:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1659117892, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:2451)");
            }
            IconKt.m2150Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g(FinancialAssetForm$lambda$136($editingCategoryName$delegate) == null ? "Add Category" : "Update Category", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$530$lambda$529$lambda$528$lambda$527$lambda$526(final java.lang.String r63, final androidx.compose.runtime.MutableState r64, final androidx.compose.runtime.MutableState r65, final androidx.compose.runtime.MutableState r66, androidx.compose.runtime.Composer r67, int r68) {
        /*
            Method dump skipped, instructions count: 997
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$530$lambda$529$lambda$528$lambda$527$lambda$526(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$528$lambda$527$lambda$526$lambda$525$lambda$524$lambda$521$lambda$520(String $catName, MutableState $editingCategoryName$delegate, MutableState $catInputName$delegate) {
        $editingCategoryName$delegate.setValue($catName);
        $catInputName$delegate.setValue($catName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$530$lambda$529$lambda$528$lambda$527$lambda$526$lambda$525$lambda$524$lambda$523$lambda$522(String $catName, MutableState $categoryToDelete$delegate) {
        $categoryToDelete$delegate.setValue($catName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$532$lambda$531(MutableState $categoryToDelete$delegate) {
        $categoryToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$540(String $catName, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C2536@125357L60:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1910868070, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2536)");
            }
            TextKt.m2693Text4IGK_g("Are you sure you want to delete category '" + $catName + "'?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$536(final String $catName, final SharedPreferences $prefs, final MutableState $categoriesList$delegate, final MutableState $category$delegate, final MutableState $categoryToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2539@125505L411,2547@126006L11,2547@125962L62,2538@125467L630:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1373646539, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2538)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1519366310, "CC(remember):FinancialAssetForm.kt#9igjgp");
            boolean changed = $composer.changed($catName) | $composer.changedInstance($prefs);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$536$lambda$535$lambda$534($catName, $categoriesList$delegate, $prefs, $category$delegate, $categoryToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$2117046491$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$536$lambda$535$lambda$534(String $catName, MutableState $categoriesList$delegate, SharedPreferences $prefs, MutableState $category$delegate, MutableState $categoryToDelete$delegate) {
        Iterable FinancialAssetForm$lambda$130 = FinancialAssetForm$lambda$130($categoriesList$delegate);
        Collection arrayList = new ArrayList();
        for (Object obj : FinancialAssetForm$lambda$130) {
            if (!StringsKt.equals((String) obj, $catName, true)) {
                arrayList.add(obj);
            }
        }
        List updated = (List) arrayList;
        FinancialAssetForm$saveCategoriesToPrefs($prefs, $categoriesList$delegate, updated);
        if (StringsKt.equals(FinancialAssetForm$lambda$13($category$delegate), $catName, true)) {
            String str = (String) CollectionsKt.firstOrNull(updated);
            if (str == null) {
                str = "Bank Account";
            }
            $category$delegate.setValue(str);
        }
        $categoryToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$539(final MutableState $categoryToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2553@126180L27,2553@126159L104:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-129451767, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2553)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 150904772, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda161
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$539$lambda$538$lambda$537(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1725384236$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$539$lambda$538$lambda$537(MutableState $categoryToDelete$delegate) {
        $categoryToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$542$lambda$541(MutableState $showManageOwnersDialog$delegate, MutableState $editingOwnerName$delegate, MutableState $ownerInputName$delegate) {
        FinancialAssetForm$lambda$118($showManageOwnersDialog$delegate, false);
        $editingOwnerName$delegate.setValue(null);
        $ownerInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x060e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$566(final androidx.compose.runtime.MutableState r79, final androidx.compose.runtime.MutableState r80, final android.content.SharedPreferences r81, final androidx.compose.runtime.MutableState r82, final androidx.compose.runtime.MutableState r83, final androidx.compose.runtime.MutableState r84, androidx.compose.runtime.Composer r85, int r86) {
        /*
            Method dump skipped, instructions count: 1989
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$566(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, android.content.SharedPreferences, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$566$lambda$565$lambda$547$lambda$546(MutableState $ownerInputName$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $ownerInputName$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$566$lambda$565$lambda$555$lambda$549$lambda$548(MutableState $editingOwnerName$delegate, MutableState $ownerInputName$delegate) {
        $editingOwnerName$delegate.setValue(null);
        $ownerInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$566$lambda$565$lambda$555$lambda$553$lambda$552(MutableState $ownerInputName$delegate, MutableState $editingOwnerName$delegate, MutableState $ownersList$delegate, SharedPreferences $ownerPrefs, MutableState $owner$delegate) {
        String trimmed = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$120($ownerInputName$delegate)).toString();
        if (!StringsKt.isBlank(trimmed)) {
            boolean z = true;
            if (FinancialAssetForm$lambda$123($editingOwnerName$delegate) != null) {
                String oldName = FinancialAssetForm$lambda$123($editingOwnerName$delegate);
                Intrinsics.checkNotNull(oldName);
                Iterable<String> FinancialAssetForm$lambda$114 = FinancialAssetForm$lambda$114($ownersList$delegate);
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(FinancialAssetForm$lambda$114, 10));
                for (String str : FinancialAssetForm$lambda$114) {
                    if (StringsKt.equals(str, oldName, true)) {
                        str = trimmed;
                    }
                    arrayList.add(str);
                }
                List updated = (List) arrayList;
                FinancialAssetForm$saveOwnersToPrefs($ownerPrefs, $ownersList$delegate, updated);
                if (StringsKt.equals(FinancialAssetForm$lambda$10($owner$delegate), oldName, true)) {
                    $owner$delegate.setValue(trimmed);
                }
            } else {
                Iterable FinancialAssetForm$lambda$1142 = FinancialAssetForm$lambda$114($ownersList$delegate);
                if (!(FinancialAssetForm$lambda$1142 instanceof Collection) || !((Collection) FinancialAssetForm$lambda$1142).isEmpty()) {
                    Iterator it = FinancialAssetForm$lambda$1142.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (StringsKt.equals((String) it.next(), trimmed, true)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    List updated2 = CollectionsKt.plus((Collection<? extends String>) FinancialAssetForm$lambda$114($ownersList$delegate), trimmed);
                    FinancialAssetForm$saveOwnersToPrefs($ownerPrefs, $ownersList$delegate, updated2);
                }
                $owner$delegate.setValue(trimmed);
            }
            $editingOwnerName$delegate.setValue(null);
            $ownerInputName$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$566$lambda$565$lambda$555$lambda$554(MutableState $editingOwnerName$delegate, RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C2644@130505L85,2645@130619L39,2646@130687L67:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(979247325, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:2644)");
            }
            IconKt.m2150Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g(FinancialAssetForm$lambda$123($editingOwnerName$delegate) == null ? "Add Owner" : "Update Owner", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$566$lambda$565$lambda$564$lambda$563$lambda$562(final java.lang.String r63, final androidx.compose.runtime.MutableState r64, final androidx.compose.runtime.MutableState r65, final androidx.compose.runtime.MutableState r66, androidx.compose.runtime.Composer r67, int r68) {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$566$lambda$565$lambda$564$lambda$563$lambda$562(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$566$lambda$565$lambda$564$lambda$563$lambda$562$lambda$561$lambda$560$lambda$557$lambda$556(String $ownerName, MutableState $editingOwnerName$delegate, MutableState $ownerInputName$delegate) {
        $editingOwnerName$delegate.setValue($ownerName);
        Intrinsics.checkNotNull($ownerName);
        $ownerInputName$delegate.setValue($ownerName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$566$lambda$565$lambda$564$lambda$563$lambda$562$lambda$561$lambda$560$lambda$559$lambda$558(String $ownerName, MutableState $ownerToDelete$delegate) {
        $ownerToDelete$delegate.setValue($ownerName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$545(final MutableState $showManageOwnersDialog$delegate, final MutableState $editingOwnerName$delegate, final MutableState $ownerInputName$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2721@134786L170,2720@134744L284:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-207442038, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2720)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1783300812, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda207
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$545$lambda$544$lambda$543(MutableState.this, $editingOwnerName$delegate, $ownerInputName$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1647393965$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$545$lambda$544$lambda$543(MutableState $showManageOwnersDialog$delegate, MutableState $editingOwnerName$delegate, MutableState $ownerInputName$delegate) {
        FinancialAssetForm$lambda$118($showManageOwnersDialog$delegate, false);
        $editingOwnerName$delegate.setValue(null);
        $ownerInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$568$lambda$567(MutableState $ownerToDelete$delegate) {
        $ownerToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$576(String $oName, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C2739@135331L63:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1754887528, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2739)");
            }
            TextKt.m2693Text4IGK_g("Are you sure you want to delete owner profile '" + $oName + "'?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$572(final String $oName, final SharedPreferences $ownerPrefs, final MutableState $ownersList$delegate, final MutableState $owner$delegate, final MutableState $ownerToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2742@135482L382,2750@135954L11,2750@135910L62,2741@135444L601:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1217665997, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2741)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1945920779, "CC(remember):FinancialAssetForm.kt#9igjgp");
            boolean changed = $composer.changed($oName) | $composer.changedInstance($ownerPrefs);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda172
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$572$lambda$571$lambda$570($oName, $ownersList$delegate, $ownerPrefs, $owner$delegate, $ownerToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1961065949$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$572$lambda$571$lambda$570(String $oName, MutableState $ownersList$delegate, SharedPreferences $ownerPrefs, MutableState $owner$delegate, MutableState $ownerToDelete$delegate) {
        Iterable FinancialAssetForm$lambda$114 = FinancialAssetForm$lambda$114($ownersList$delegate);
        Collection arrayList = new ArrayList();
        for (Object obj : FinancialAssetForm$lambda$114) {
            if (!StringsKt.equals((String) obj, $oName, true)) {
                arrayList.add(obj);
            }
        }
        List updated = (List) arrayList;
        FinancialAssetForm$saveOwnersToPrefs($ownerPrefs, $ownersList$delegate, updated);
        if (StringsKt.equals(FinancialAssetForm$lambda$10($owner$delegate), $oName, true)) {
            String str = (String) CollectionsKt.firstOrNull(updated);
            if (str == null) {
                str = "Self";
            }
            $owner$delegate.setValue(str);
        }
        $ownerToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$575(final MutableState $ownerToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2756@136128L24,2756@136107L101:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-285432309, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2756)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 577459267, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda130
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$575$lambda$574$lambda$573(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1569403694$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$575$lambda$574$lambda$573(MutableState $ownerToDelete$delegate) {
        $ownerToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$578$lambda$577(MutableState $showManageTitlesDialog$delegate, MutableState $editingTitleName$delegate, MutableState $titleInputName$delegate) {
        FinancialAssetForm$lambda$66($showManageTitlesDialog$delegate, false);
        $editingTitleName$delegate.setValue(null);
        $titleInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x060e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$602(final androidx.compose.runtime.MutableState r79, final androidx.compose.runtime.MutableState r80, final android.content.SharedPreferences r81, final androidx.compose.runtime.MutableState r82, final androidx.compose.runtime.MutableState r83, final androidx.compose.runtime.MutableState r84, androidx.compose.runtime.Composer r85, int r86) {
        /*
            Method dump skipped, instructions count: 1989
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$602(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, android.content.SharedPreferences, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$602$lambda$601$lambda$583$lambda$582(MutableState $titleInputName$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $titleInputName$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$602$lambda$601$lambda$591$lambda$585$lambda$584(MutableState $editingTitleName$delegate, MutableState $titleInputName$delegate) {
        $editingTitleName$delegate.setValue(null);
        $titleInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$602$lambda$601$lambda$591$lambda$589$lambda$588(MutableState $titleInputName$delegate, MutableState $editingTitleName$delegate, MutableState $titlesList$delegate, SharedPreferences $titlePrefs, MutableState $title$delegate) {
        String trimmed = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$68($titleInputName$delegate)).toString();
        if (!StringsKt.isBlank(trimmed)) {
            boolean z = true;
            if (FinancialAssetForm$lambda$71($editingTitleName$delegate) != null) {
                String oldName = FinancialAssetForm$lambda$71($editingTitleName$delegate);
                Intrinsics.checkNotNull(oldName);
                Iterable<String> FinancialAssetForm$lambda$62 = FinancialAssetForm$lambda$62($titlesList$delegate);
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(FinancialAssetForm$lambda$62, 10));
                for (String str : FinancialAssetForm$lambda$62) {
                    if (StringsKt.equals(str, oldName, true)) {
                        str = trimmed;
                    }
                    arrayList.add(str);
                }
                List updated = (List) arrayList;
                FinancialAssetForm$saveTitlesToPrefs($titlePrefs, $titlesList$delegate, updated);
                if (StringsKt.equals(FinancialAssetForm$lambda$1($title$delegate), oldName, true)) {
                    $title$delegate.setValue(trimmed);
                }
            } else {
                Iterable FinancialAssetForm$lambda$622 = FinancialAssetForm$lambda$62($titlesList$delegate);
                if (!(FinancialAssetForm$lambda$622 instanceof Collection) || !((Collection) FinancialAssetForm$lambda$622).isEmpty()) {
                    Iterator it = FinancialAssetForm$lambda$622.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (StringsKt.equals((String) it.next(), trimmed, true)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    List updated2 = CollectionsKt.plus((Collection<? extends String>) FinancialAssetForm$lambda$62($titlesList$delegate), trimmed);
                    FinancialAssetForm$saveTitlesToPrefs($titlePrefs, $titlesList$delegate, updated2);
                }
                $title$delegate.setValue(trimmed);
            }
            $editingTitleName$delegate.setValue(null);
            $titleInputName$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$602$lambda$601$lambda$591$lambda$590(MutableState $editingTitleName$delegate, RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C2845@140391L85,2846@140505L39,2847@140573L67:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(823266783, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:2845)");
            }
            IconKt.m2150Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g(FinancialAssetForm$lambda$71($editingTitleName$delegate) == null ? "Add Title" : "Update Title", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$602$lambda$601$lambda$600$lambda$599$lambda$598(final java.lang.String r63, final androidx.compose.runtime.MutableState r64, final androidx.compose.runtime.MutableState r65, final androidx.compose.runtime.MutableState r66, androidx.compose.runtime.Composer r67, int r68) {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$602$lambda$601$lambda$600$lambda$599$lambda$598(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$602$lambda$601$lambda$600$lambda$599$lambda$598$lambda$597$lambda$596$lambda$593$lambda$592(String $tName, MutableState $editingTitleName$delegate, MutableState $titleInputName$delegate) {
        $editingTitleName$delegate.setValue($tName);
        Intrinsics.checkNotNull($tName);
        $titleInputName$delegate.setValue($tName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$602$lambda$601$lambda$600$lambda$599$lambda$598$lambda$597$lambda$596$lambda$595$lambda$594(String $tName, MutableState $titleToDelete$delegate) {
        $titleToDelete$delegate.setValue($tName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$581(final MutableState $showManageTitlesDialog$delegate, final MutableState $editingTitleName$delegate, final MutableState $titleInputName$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2921@144610L170,2920@144568L284:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-363422580, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2920)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1356746314, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda187
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$581$lambda$580$lambda$579(MutableState.this, $editingTitleName$delegate, $titleInputName$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1491413423$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$581$lambda$580$lambda$579(MutableState $showManageTitlesDialog$delegate, MutableState $editingTitleName$delegate, MutableState $titleInputName$delegate) {
        FinancialAssetForm$lambda$66($showManageTitlesDialog$delegate, false);
        $editingTitleName$delegate.setValue(null);
        $titleInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$604$lambda$603(MutableState $titleToDelete$delegate) {
        $titleToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$612(String $tName, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C2939@145154L74:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1598906986, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2939)");
            }
            TextKt.m2693Text4IGK_g("Are you sure you want to delete '" + $tName + "' from saved title options?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$608(final String $tName, final SharedPreferences $titlePrefs, final MutableState $titlesList$delegate, final MutableState $title$delegate, final MutableState $titleToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2942@145316L378,2950@145784L11,2950@145740L62,2941@145278L597:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1061685455, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2941)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1922492023, "CC(remember):FinancialAssetForm.kt#9igjgp");
            boolean changed = $composer.changed($tName) | $composer.changedInstance($titlePrefs);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda98
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$608$lambda$607$lambda$606($tName, $titlesList$delegate, $titlePrefs, $title$delegate, $titleToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1805085407$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$608$lambda$607$lambda$606(String $tName, MutableState $titlesList$delegate, SharedPreferences $titlePrefs, MutableState $title$delegate, MutableState $titleToDelete$delegate) {
        Iterable FinancialAssetForm$lambda$62 = FinancialAssetForm$lambda$62($titlesList$delegate);
        Collection arrayList = new ArrayList();
        for (Object obj : FinancialAssetForm$lambda$62) {
            if (!StringsKt.equals((String) obj, $tName, true)) {
                arrayList.add(obj);
            }
        }
        List updated = (List) arrayList;
        FinancialAssetForm$saveTitlesToPrefs($titlePrefs, $titlesList$delegate, updated);
        if (StringsKt.equals(FinancialAssetForm$lambda$1($title$delegate), $tName, true)) {
            String str = (String) CollectionsKt.firstOrNull(updated);
            if (str == null) {
                str = "";
            }
            $title$delegate.setValue(str);
        }
        $titleToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$611(final MutableState $titleToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C2956@145958L24,2956@145937L101:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-441412851, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:2956)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1004013765, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$611$lambda$610$lambda$609(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1413423152$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$611$lambda$610$lambda$609(MutableState $titleToDelete$delegate) {
        $titleToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$614$lambda$613(MutableState $showManageInstitutionsDialog$delegate, MutableState $editingInstitutionName$delegate, MutableState $institutionInputName$delegate) {
        FinancialAssetForm$lambda$84($showManageInstitutionsDialog$delegate, false);
        $editingInstitutionName$delegate.setValue(null);
        $institutionInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x060e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$638(final androidx.compose.runtime.MutableState r79, final androidx.compose.runtime.MutableState r80, final android.content.SharedPreferences r81, final androidx.compose.runtime.MutableState r82, final androidx.compose.runtime.MutableState r83, final androidx.compose.runtime.MutableState r84, androidx.compose.runtime.Composer r85, int r86) {
        /*
            Method dump skipped, instructions count: 1989
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$638(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, android.content.SharedPreferences, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$638$lambda$637$lambda$619$lambda$618(MutableState $institutionInputName$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $institutionInputName$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$638$lambda$637$lambda$627$lambda$621$lambda$620(MutableState $editingInstitutionName$delegate, MutableState $institutionInputName$delegate) {
        $editingInstitutionName$delegate.setValue(null);
        $institutionInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$638$lambda$637$lambda$627$lambda$625$lambda$624(MutableState $institutionInputName$delegate, MutableState $editingInstitutionName$delegate, MutableState $institutionsList$delegate, SharedPreferences $instPrefs, MutableState $institution$delegate) {
        String trimmed = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$86($institutionInputName$delegate)).toString();
        if (!StringsKt.isBlank(trimmed)) {
            boolean z = true;
            if (FinancialAssetForm$lambda$89($editingInstitutionName$delegate) != null) {
                String oldName = FinancialAssetForm$lambda$89($editingInstitutionName$delegate);
                Intrinsics.checkNotNull(oldName);
                Iterable<String> FinancialAssetForm$lambda$80 = FinancialAssetForm$lambda$80($institutionsList$delegate);
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(FinancialAssetForm$lambda$80, 10));
                for (String str : FinancialAssetForm$lambda$80) {
                    if (StringsKt.equals(str, oldName, true)) {
                        str = trimmed;
                    }
                    arrayList.add(str);
                }
                List updated = (List) arrayList;
                FinancialAssetForm$saveInstitutionsToPrefs($instPrefs, $institutionsList$delegate, updated);
                if (StringsKt.equals(FinancialAssetForm$lambda$4($institution$delegate), oldName, true)) {
                    $institution$delegate.setValue(trimmed);
                }
            } else {
                Iterable FinancialAssetForm$lambda$802 = FinancialAssetForm$lambda$80($institutionsList$delegate);
                if (!(FinancialAssetForm$lambda$802 instanceof Collection) || !((Collection) FinancialAssetForm$lambda$802).isEmpty()) {
                    Iterator it = FinancialAssetForm$lambda$802.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (StringsKt.equals((String) it.next(), trimmed, true)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    List updated2 = CollectionsKt.plus((Collection<? extends String>) FinancialAssetForm$lambda$80($institutionsList$delegate), trimmed);
                    FinancialAssetForm$saveInstitutionsToPrefs($instPrefs, $institutionsList$delegate, updated2);
                }
                $institution$delegate.setValue(trimmed);
            }
            $editingInstitutionName$delegate.setValue(null);
            $institutionInputName$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$638$lambda$637$lambda$627$lambda$626(MutableState $editingInstitutionName$delegate, RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C3045@150394L85,3046@150508L39,3047@150576L85:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(667286241, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:3045)");
            }
            IconKt.m2150Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g(FinancialAssetForm$lambda$89($editingInstitutionName$delegate) == null ? "Add Institution" : "Update Institution", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$638$lambda$637$lambda$636$lambda$635$lambda$634(final java.lang.String r63, final androidx.compose.runtime.MutableState r64, final androidx.compose.runtime.MutableState r65, final androidx.compose.runtime.MutableState r66, androidx.compose.runtime.Composer r67, int r68) {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$638$lambda$637$lambda$636$lambda$635$lambda$634(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$638$lambda$637$lambda$636$lambda$635$lambda$634$lambda$633$lambda$632$lambda$629$lambda$628(String $instName, MutableState $editingInstitutionName$delegate, MutableState $institutionInputName$delegate) {
        $editingInstitutionName$delegate.setValue($instName);
        Intrinsics.checkNotNull($instName);
        $institutionInputName$delegate.setValue($instName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$638$lambda$637$lambda$636$lambda$635$lambda$634$lambda$633$lambda$632$lambda$631$lambda$630(String $instName, MutableState $institutionToDelete$delegate) {
        $institutionToDelete$delegate.setValue($instName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$617(final MutableState $showManageInstitutionsDialog$delegate, final MutableState $editingInstitutionName$delegate, final MutableState $institutionInputName$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C3121@154697L188,3120@154655L302:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-519403122, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:3120)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -930191798, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$617$lambda$616$lambda$615(MutableState.this, $editingInstitutionName$delegate, $institutionInputName$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1335432881$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$617$lambda$616$lambda$615(MutableState $showManageInstitutionsDialog$delegate, MutableState $editingInstitutionName$delegate, MutableState $institutionInputName$delegate) {
        FinancialAssetForm$lambda$84($showManageInstitutionsDialog$delegate, false);
        $editingInstitutionName$delegate.setValue(null);
        $institutionInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$640$lambda$639(MutableState $institutionToDelete$delegate) {
        $institutionToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$648(String $instName, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C3139@155285L76:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1137140949, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:3139)");
            }
            TextKt.m2693Text4IGK_g("Are you sure you want to delete '" + $instName + "' from saved institutions?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$644(final String $instName, final SharedPreferences $instPrefs, final MutableState $institutionsList$delegate, final MutableState $institution$delegate, final MutableState $institutionToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C3142@155449L414,3150@155953L11,3150@155909L62,3141@155411L633:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-611139226, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:3141)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1105725572, "CC(remember):FinancialAssetForm.kt#9igjgp");
            boolean changed = $composer.changed($instName) | $composer.changedInstance($instPrefs);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda145
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$644$lambda$643$lambda$642($instName, $institutionsList$delegate, $instPrefs, $institution$delegate, $institutionToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$959422806$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$644$lambda$643$lambda$642(String $instName, MutableState $institutionsList$delegate, SharedPreferences $instPrefs, MutableState $institution$delegate, MutableState $institutionToDelete$delegate) {
        Iterable FinancialAssetForm$lambda$80 = FinancialAssetForm$lambda$80($institutionsList$delegate);
        Collection arrayList = new ArrayList();
        for (Object obj : FinancialAssetForm$lambda$80) {
            if (!StringsKt.equals((String) obj, $instName, true)) {
                arrayList.add(obj);
            }
        }
        List updated = (List) arrayList;
        FinancialAssetForm$saveInstitutionsToPrefs($instPrefs, $institutionsList$delegate, updated);
        if (StringsKt.equals(FinancialAssetForm$lambda$4($institution$delegate), $instName, true)) {
            String str = (String) CollectionsKt.firstOrNull(updated);
            if (str == null) {
                str = "";
            }
            $institution$delegate.setValue(str);
        }
        $institutionToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$647(final MutableState $institutionToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C3156@156127L30,3156@156106L107:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(37453544, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:3156)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1633118694, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda190
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$647$lambda$646$lambda$645(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1702794789$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$647$lambda$646$lambda$645(MutableState $institutionToDelete$delegate) {
        $institutionToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$650$lambda$649(MutableState $showManageAccountNumbersDialog$delegate, MutableState $editingAccountNumberName$delegate, MutableState $accountNumberInputName$delegate) {
        FinancialAssetForm$lambda$102($showManageAccountNumbersDialog$delegate, false);
        $editingAccountNumberName$delegate.setValue(null);
        $accountNumberInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x07bf  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x060e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$674(final androidx.compose.runtime.MutableState r79, final androidx.compose.runtime.MutableState r80, final android.content.SharedPreferences r81, final androidx.compose.runtime.MutableState r82, final androidx.compose.runtime.MutableState r83, final androidx.compose.runtime.MutableState r84, androidx.compose.runtime.Composer r85, int r86) {
        /*
            Method dump skipped, instructions count: 1989
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$674(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, android.content.SharedPreferences, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$674$lambda$673$lambda$655$lambda$654(MutableState $accountNumberInputName$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $accountNumberInputName$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$674$lambda$673$lambda$663$lambda$657$lambda$656(MutableState $editingAccountNumberName$delegate, MutableState $accountNumberInputName$delegate) {
        $editingAccountNumberName$delegate.setValue(null);
        $accountNumberInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$674$lambda$673$lambda$663$lambda$661$lambda$660(MutableState $accountNumberInputName$delegate, MutableState $editingAccountNumberName$delegate, MutableState $accountNumbersList$delegate, SharedPreferences $accNoPrefs, MutableState $accountNumber$delegate) {
        String trimmed = StringsKt.trim((CharSequence) FinancialAssetForm$lambda$104($accountNumberInputName$delegate)).toString();
        if (!StringsKt.isBlank(trimmed)) {
            boolean z = true;
            if (FinancialAssetForm$lambda$107($editingAccountNumberName$delegate) != null) {
                String oldName = FinancialAssetForm$lambda$107($editingAccountNumberName$delegate);
                Intrinsics.checkNotNull(oldName);
                Iterable<String> FinancialAssetForm$lambda$98 = FinancialAssetForm$lambda$98($accountNumbersList$delegate);
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(FinancialAssetForm$lambda$98, 10));
                for (String str : FinancialAssetForm$lambda$98) {
                    if (StringsKt.equals(str, oldName, true)) {
                        str = trimmed;
                    }
                    arrayList.add(str);
                }
                List updated = (List) arrayList;
                FinancialAssetForm$saveAccountNumbersToPrefs($accNoPrefs, $accountNumbersList$delegate, updated);
                if (StringsKt.equals(FinancialAssetForm$lambda$7($accountNumber$delegate), oldName, true)) {
                    $accountNumber$delegate.setValue(trimmed);
                }
            } else {
                Iterable FinancialAssetForm$lambda$982 = FinancialAssetForm$lambda$98($accountNumbersList$delegate);
                if (!(FinancialAssetForm$lambda$982 instanceof Collection) || !((Collection) FinancialAssetForm$lambda$982).isEmpty()) {
                    Iterator it = FinancialAssetForm$lambda$982.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (StringsKt.equals((String) it.next(), trimmed, true)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    List updated2 = CollectionsKt.plus((Collection<? extends String>) FinancialAssetForm$lambda$98($accountNumbersList$delegate), trimmed);
                    FinancialAssetForm$saveAccountNumbersToPrefs($accNoPrefs, $accountNumbersList$delegate, updated2);
                }
                $accountNumber$delegate.setValue(trimmed);
            }
            $editingAccountNumberName$delegate.setValue(null);
            $accountNumberInputName$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$674$lambda$673$lambda$663$lambda$662(MutableState $editingAccountNumberName$delegate, RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C3245@160637L85,3246@160751L39,3247@160819L77:FinancialAssetForm.kt#qonjpd");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1907872138, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FinancialAssetForm.kt:3245)");
            }
            IconKt.m2150Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(16)), 0L, $composer, 432, 8);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6622constructorimpl(4)), $composer, 6);
            TextKt.m2693Text4IGK_g(FinancialAssetForm$lambda$107($editingAccountNumberName$delegate) == null ? "Add Number" : "Update Number", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit FinancialAssetForm$lambda$674$lambda$673$lambda$672$lambda$671$lambda$670(final java.lang.String r63, final androidx.compose.runtime.MutableState r64, final androidx.compose.runtime.MutableState r65, final androidx.compose.runtime.MutableState r66, androidx.compose.runtime.Composer r67, int r68) {
        /*
            Method dump skipped, instructions count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.components.FinancialAssetFormKt.FinancialAssetForm$lambda$674$lambda$673$lambda$672$lambda$671$lambda$670(java.lang.String, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$674$lambda$673$lambda$672$lambda$671$lambda$670$lambda$669$lambda$668$lambda$665$lambda$664(String $accNum, MutableState $editingAccountNumberName$delegate, MutableState $accountNumberInputName$delegate) {
        $editingAccountNumberName$delegate.setValue($accNum);
        Intrinsics.checkNotNull($accNum);
        $accountNumberInputName$delegate.setValue($accNum);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$674$lambda$673$lambda$672$lambda$671$lambda$670$lambda$669$lambda$668$lambda$667$lambda$666(String $accNum, MutableState $accountNumberToDelete$delegate) {
        $accountNumberToDelete$delegate.setValue($accNum);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$653(final MutableState $showManageAccountNumbersDialog$delegate, final MutableState $editingAccountNumberName$delegate, final MutableState $accountNumberInputName$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C3321@164939L194,3320@164897L308:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-40536727, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:3320)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -301086869, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda132
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$653$lambda$652$lambda$651(MutableState.this, $editingAccountNumberName$delegate, $accountNumberInputName$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1624804518$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$653$lambda$652$lambda$651(MutableState $showManageAccountNumbersDialog$delegate, MutableState $editingAccountNumberName$delegate, MutableState $accountNumberInputName$delegate) {
        FinancialAssetForm$lambda$102($showManageAccountNumbersDialog$delegate, false);
        $editingAccountNumberName$delegate.setValue(null);
        $accountNumberInputName$delegate.setValue("");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$676$lambda$675(MutableState $accountNumberToDelete$delegate) {
        $accountNumberToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$684(String $accNum, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C3339@165543L69:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1293121491, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:3339)");
            }
            TextKt.m2693Text4IGK_g("Are you sure you want to delete '" + $accNum + "' from saved numbers?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$680(final String $accNum, final SharedPreferences $accNoPrefs, final MutableState $accountNumbersList$delegate, final MutableState $accountNumber$delegate, final MutableState $accountNumberToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C3342@165700L420,3350@166210L11,3350@166166L62,3341@165662L639:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-767119768, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:3341)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1532280076, "CC(remember):FinancialAssetForm.kt#9igjgp");
            boolean changed = $composer.changed($accNum) | $composer.changedInstance($accNoPrefs);
            Object rememberedValue = $composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda164
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$680$lambda$679$lambda$678($accNum, $accountNumbersList$delegate, $accNoPrefs, $accountNumber$delegate, $accountNumberToDelete$delegate);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button((Function0) obj, null, false, null, ButtonDefaults.INSTANCE.m1809buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$803442264$app(), $composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$680$lambda$679$lambda$678(String $accNum, MutableState $accountNumbersList$delegate, SharedPreferences $accNoPrefs, MutableState $accountNumber$delegate, MutableState $accountNumberToDelete$delegate) {
        Iterable FinancialAssetForm$lambda$98 = FinancialAssetForm$lambda$98($accountNumbersList$delegate);
        Collection arrayList = new ArrayList();
        for (Object obj : FinancialAssetForm$lambda$98) {
            if (!StringsKt.equals((String) obj, $accNum, true)) {
                arrayList.add(obj);
            }
        }
        List updated = (List) arrayList;
        FinancialAssetForm$saveAccountNumbersToPrefs($accNoPrefs, $accountNumbersList$delegate, updated);
        if (StringsKt.equals(FinancialAssetForm$lambda$7($accountNumber$delegate), $accNum, true)) {
            String str = (String) CollectionsKt.firstOrNull(updated);
            if (str == null) {
                str = "";
            }
            $accountNumber$delegate.setValue(str);
        }
        $accountNumberToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$683(final MutableState $accountNumberToDelete$delegate, Composer $composer, int $changed) {
        Object obj;
        ComposerKt.sourceInformation($composer, "C3356@166384L32,3356@166363L109:FinancialAssetForm.kt#qonjpd");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-118526998, $changed, -1, "com.example.ui.components.FinancialAssetForm.<anonymous> (FinancialAssetForm.kt:3356)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 2059673194, "CC(remember):FinancialAssetForm.kt#9igjgp");
            Object rememberedValue = $composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.components.FinancialAssetFormKt$$ExternalSyntheticLambda144
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinancialAssetFormKt.FinancialAssetForm$lambda$683$lambda$682$lambda$681(MutableState.this);
                    }
                };
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) obj, null, false, null, null, null, null, null, null, ComposableSingletons$FinancialAssetFormKt.INSTANCE.getLambda$1546814247$app(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FinancialAssetForm$lambda$683$lambda$682$lambda$681(MutableState $accountNumberToDelete$delegate) {
        $accountNumberToDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }
}
